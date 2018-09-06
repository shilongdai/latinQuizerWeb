package net.viperfish.latinQuiz.quizers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.LatinVerbDatabase;
import net.viperfish.latinQuiz.core.Mood;
import net.viperfish.latinQuiz.core.Question;
import net.viperfish.latinQuiz.core.QuestionType;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbType;
import net.viperfish.latinQuiz.core.Voice;
import net.viperfish.latinQuiz.errors.InsufficientWordBankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("verbService")
public final class VerbQuizerService {

	private SecureRandom rand;
	private LatinVerbDatabase database;
	private Map<QuestionType, VerbQuestionGenerator> generators;

	public VerbQuizerService() {
		rand = new SecureRandom();
		generators = new HashMap<>();
	}

	private void init(MessageSource i18n) {
		generators.put(QuestionType.MULTIPLE_CHOICE, new VerbMultipleChoiceQuestionGenerator(i18n));
		generators.put(QuestionType.SYNOPSIS, new VerbSynopsisQuestionGenerator(i18n));
	}

	@Autowired
	public void setDatabase(LatinVerbDatabase database) {
		this.database = database;
	}

	@Autowired
	public void setI18n(MessageSource i18n) {
		init(i18n);
	}

	public Question[] generateQuestions(int length, Integer[] conjugations, List<Tense> tenses,
			List<Voice> voices,
			List<Mood> moods, List<VerbType> types, List<QuestionType> questionTypes)
			throws InsufficientWordBankException {
		// make sure that there are words in the word bank and that there are the
		// established conjugations
		checkParameters(length, conjugations);
		int currentConj = 0;
		HashSet<String> buffer = new HashSet<>();
		List<Question> result = new LinkedList<>();
		for (int k = 0; k < length; ++k) {
			VerbType type = types.get(rand.nextInt(types.size()));
			QuestionType questionType = questionTypes.get(rand.nextInt(questionTypes.size()));
			// get a random verb from the current selecting conjugation
			LatinVerb l = getVerb(conjugations[currentConj], type);
			if (l == null) {
				currentConj = (currentConj + 1) % conjugations.length;
				k--;
				continue;
			}
			VerbQuestionGenerator gen = generators.get(questionType);
			Question q = gen.generate(l, conjugations, tenses, voices, moods);

			// if this question exists, generate another one
			if (buffer.contains(q.getQuestion())) {
				--k;
				continue;
			}
			result.add(q);
			buffer.add(q.getQuestion());
			currentConj = (currentConj + 1) % conjugations.length;
		}
		Collections.shuffle(result);
		return result.toArray(new Question[result.size()]);

	}

	private LatinVerb getVerb(int conj, VerbType type) {
		LatinVerb l = null;
		List<LatinVerb> conjVs = database.findAllByConjugationAndType(conj, type);
		if (conjVs.isEmpty()) {
			return null;
		}
		l = conjVs.get(rand.nextInt(conjVs.size()));
		return l;
	}

	private void checkParameters(int length, Integer[] conjugations)
			throws InsufficientWordBankException {
		if (database.count() == 0) {
			throw new InsufficientWordBankException();
		}
		if (conjugations.length > 6) {
			throw new IllegalArgumentException(Arrays.toString(conjugations));
		}
	}

}
