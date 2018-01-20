package net.viperfish.latinQuiz.quizers;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.LatinVerbDatabase;
import net.viperfish.latinQuiz.core.MultipleChoiceQuestion;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.errors.InsufficientWordBankException;

@Service("verbService")
public final class VerbQuizerService {

	private SecureRandom rand;
	private LatinVerbDatabase database;
	private MessageSource i18n;

	public VerbQuizerService() {
		rand = new SecureRandom();
	}

	@Autowired
	public void setDatabase(LatinVerbDatabase database) {
		this.database = database;
	}

	@Autowired
	public void setI18n(MessageSource i18n) {
		this.i18n = i18n;
	}

	public MultipleChoiceQuestion[] generateQuestions(int length, Integer[] conjugations, List<Tense> tenses)
			throws InsufficientWordBankException {
		// make sure that there are words in the word bank and that there are the
		// established conjugations
		checkParameters(length, conjugations);
		int currentConj = 0;
		HashSet<String> buffer = new HashSet<>();
		List<MultipleChoiceQuestion> result = new LinkedList<>();
		for (int k = 0; k < length; ++k) {
			// get a random verb from the current selecting conjugation
			LatinVerb l = getVerb(conjugations[currentConj]);
			if (l == null) {
				currentConj = (currentConj + 1) % conjugations.length;
				k--;
				continue;
			}
			// select and conjugate a random tense
			Tense t = tenses.get(rand.nextInt(tenses.size()));
			String[][] conjugated = l.conjugate(t);
			while (conjugated == null) {
				t = Tense.values()[rand.nextInt(Tense.values().length)];
				conjugated = l.conjugate(t);
			}
			// select the right answer
			int personIndex = rand.nextInt(conjugated.length);
			int numberIndex = rand.nextInt(conjugated[personIndex].length);

			// generate the question
			String localizedTense = i18n.getMessage(t.name(), null, LocaleContextHolder.getLocale());
			String localizedPerson = i18n.getMessage(personToKey(personIndex), null, LocaleContextHolder.getLocale());
			String localizedNumber = i18n.getMessage(numberToKey(numberIndex), null, LocaleContextHolder.getLocale());
			String question = i18n.getMessage("practice.verb.multipleChoice", new Object[] { l.getDictionaryEntry(),
					localizedTense, "Indicative", localizedPerson, localizedNumber }, LocaleContextHolder.getLocale());

			// if this question exists, generate another one
			if (buffer.contains(question)) {
				--k;
				continue;
			}
			HashSet<String> choices = new HashSet<>();
			String correctChoice = conjugated[personIndex][numberIndex];
			choices.add(correctChoice);
			// create the choices
			generateChoices(l, 4, choices);
			List<String> choiceList = new LinkedList<>(choices);
			Collections.shuffle(choiceList);
			MultipleChoiceQuestion questionResult = createMultipleChoice(question, choiceList, correctChoice);
			result.add(questionResult);
			buffer.add(question);
			currentConj = (currentConj + 1) % conjugations.length;
		}
		Collections.shuffle(result);
		return result.toArray(new MultipleChoiceQuestion[result.size()]);

	}

	private MultipleChoiceQuestion createMultipleChoice(String questionStr, List<String> choiceList,
			String correctChoice) {
		MultipleChoiceQuestion question = new MultipleChoiceQuestion(questionStr);
		for (int i = 0; i < choiceList.size(); ++i) {
			if (choiceList.get(i).equals(correctChoice)) {
				question.addChoice(choiceList.get(i), true);
			} else {
				question.addChoice(choiceList.get(i), false);
			}
		}
		return question;
	}

	private LatinVerb getVerb(int conj) {
		LatinVerb l = null;
		List<LatinVerb> conjVs = database.findAllByConjugation(conj);
		if (conjVs.isEmpty()) {
			return null;
		}
		l = conjVs.get(rand.nextInt(conjVs.size()));
		return l;
	}

	private void generateChoices(LatinVerb v, int amount, Set<String> choices) {
		List<String> mesh = createMesh(v);
		while (choices.size() != amount) {
			choices.add(mesh.get(rand.nextInt(mesh.size())));
		}
	}

	private void checkParameters(int length, Integer[] conjugations) throws InsufficientWordBankException {
		if (database.count() == 0) {
			throw new InsufficientWordBankException();
		}
		if (conjugations.length > 6) {
			throw new IllegalArgumentException(Arrays.toString(conjugations));
		}
	}

	private String personToKey(int num) {
		switch (num) {
		case 0: {
			return "first";
		}
		case 1: {
			return "second";
		}
		case 2: {
			return "third";
		}
		default: {
			throw new IllegalArgumentException();
		}
		}
	}

	private String numberToKey(int num) {
		if (num == 0) {
			return "singular";
		} else {
			return "plural";
		}
	}

	private List<String> createMesh(LatinVerb v) {
		List<String> result = new LinkedList<>();
		for (Tense t : Tense.values()) {
			result.addAll(flatten(v.conjugate(t)));
		}
		return result;
	}

	private <T> List<T> flatten(T[][] src) {
		List<T> result = new ArrayList<>();
		if (src == null) {
			return result;
		}
		for (int i = 0; i < src.length; ++i) {
			for (int j = 0; j < src[i].length; ++j) {
				result.add(src[i][j]);
			}
		}
		return result;

	}

}
