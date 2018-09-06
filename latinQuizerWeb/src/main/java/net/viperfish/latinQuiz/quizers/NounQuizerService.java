package net.viperfish.latinQuiz.quizers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.viperfish.latinQuiz.core.Gender;
import net.viperfish.latinQuiz.core.LatinNoun;
import net.viperfish.latinQuiz.core.LatinNounDatabase;
import net.viperfish.latinQuiz.core.NounType;
import net.viperfish.latinQuiz.core.Question;
import net.viperfish.latinQuiz.core.QuestionType;
import net.viperfish.latinQuiz.errors.InsufficientWordBankException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service("nounService")
public class NounQuizerService {

	private SecureRandom rand;
	private LatinNounDatabase database;
	private Map<QuestionType, NounQuestionGenerator> generators;

	public NounQuizerService() {
		rand = new SecureRandom();
		generators = new HashMap<>();
	}

	private void init(MessageSource i18n) {
		generators.put(QuestionType.MULTIPLE_CHOICE, new NounMultipleChoiceQuestionGenerator(i18n));
	}

	@Autowired
	public void setDatabase(LatinNounDatabase database) {
		this.database = database;
	}

	@Autowired
	public void setI18n(MessageSource i18n) {
		init(i18n);
	}

	public Question[] generateQuestions(int length, Integer[] declensions, List<Gender> genders,
			List<NounType> types,
			List<QuestionType> questionTypes) throws InsufficientWordBankException {
		// make sure that there are words in the word bank and that there are
		// the
		// established conjugations
		checkParameters(length, declensions);
		int currentDec = 0;
		HashSet<String> buffer = new HashSet<>();
		List<Question> result = new LinkedList<>();
		for (int k = 0; k < length; ++k) {
			NounType type = types.get(rand.nextInt(types.size()));
			Gender g = genders.get(rand.nextInt(genders.size()));
			QuestionType questionType = questionTypes.get(rand.nextInt(questionTypes.size()));
			// get a random verb from the current selecting conjugation
			LatinNoun n = getNoun(declensions[currentDec], g, type);
			if (n == null) {
				currentDec = (currentDec + 1) % declensions.length;
				k--;
				continue;
			}
			NounQuestionGenerator gen = generators.get(questionType);
			Question q = gen.generate(n, declensions, genders, types);
			if (q == null) {
				--k;
				continue;
			}

			// if this question exists, generate another one
			if (buffer.contains(q.getQuestion())) {
				--k;
				continue;
			}
			result.add(q);
			buffer.add(q.getQuestion());
			currentDec = (currentDec + 1) % declensions.length;
		}
		Collections.shuffle(result);
		return result.toArray(new Question[result.size()]);

	}

	private LatinNoun getNoun(int dec, Gender gender, NounType type) {
		LatinNoun n = null;
		List<LatinNoun> nouns = database.findAllByDeclensionAndGenderAndType(dec, gender, type);
		if (nouns.isEmpty()) {
			return null;
		}
		n = nouns.get(rand.nextInt(nouns.size()));
		return n;
	}

	private void checkParameters(int length, Integer[] declensions)
			throws InsufficientWordBankException {
		if (database.count() == 0) {
			throw new InsufficientWordBankException();
		}
		if (declensions.length > 4) {
			throw new IllegalArgumentException(Arrays.toString(declensions));
		}
	}

}
