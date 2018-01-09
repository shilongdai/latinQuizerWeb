package net.viperfish.latinQuiz.quizers;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

	public VerbQuizerService() {
		rand = new SecureRandom();
	}

	@Autowired
	public void setDatabase(LatinVerbDatabase database) {
		this.database = database;
	}

	public MultipleChoiceQuestion[] generateQuestions(int length, int[] conjugations)
			throws InsufficientWordBankException {
		checkParameters(length, conjugations);
		if (conjugations.length == 0) {
			conjugations = new int[4];
			for (int i = 0; i < 4; ++i) {
				conjugations[i] = i + 1;
			}
		}
		int currentConj = 0;
		HashSet<String> buffer = new HashSet<>();
		List<MultipleChoiceQuestion> result = new LinkedList<>();
		for (int k = 0; k < length; ++k) {
			LatinVerb l = getVerb(conjugations[currentConj]);
			if (l == null) {
				currentConj = (currentConj + 1) % conjugations.length;
				k--;
				continue;
			}
			StringBuilder sb = new StringBuilder("Conjugate the verb ");
			sb.append(l.getDictionaryEntry()).append(" in ");
			Tense t = Tense.values()[rand.nextInt(Tense.values().length)];
			String[][] conjugated = l.conjugate(t);
			int personIndex = rand.nextInt(conjugated.length);
			int numberIndex = rand.nextInt(conjugated[personIndex].length);
			sb.append(personToEnglish(personIndex)).append(" ").append(numberToEnglish(numberIndex)).append(" ")
					.append(tenseToEnglish(t));
			if (buffer.contains(sb.toString())) {
				--k;
				continue;
			}
			HashSet<String> choices = new HashSet<>();
			String correctChoice = conjugated[personIndex][numberIndex];
			choices.add(correctChoice);
			generateChoices(conjugated, 4, choices);
			List<String> choiceList = new LinkedList<>(choices);
			Collections.shuffle(choiceList);
			MultipleChoiceQuestion question = createMultipleChoice(sb.toString(), choiceList, correctChoice);
			result.add(question);
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

	private void generateChoices(String[][] conjugated, int amount, Set<String> choices) {
		while (choices.size() != amount) {
			int personIndex = rand.nextInt(conjugated.length);
			int numberIndex = rand.nextInt(conjugated[personIndex].length);
			choices.add(conjugated[personIndex][numberIndex]);
		}
	}

	private void checkParameters(int length, int[] conjugations) throws InsufficientWordBankException {
		if (database.count() == 0) {
			throw new InsufficientWordBankException();
		}
		if (conjugations.length > 4) {
			throw new IllegalArgumentException(Arrays.toString(conjugations));
		}
	}

	private String personToEnglish(int num) {
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

	private String numberToEnglish(int num) {
		if (num == 0) {
			return "singular";
		} else {
			return "plural";
		}
	}

	private String tenseToEnglish(Tense t) {
		switch (t) {
		case FUTURE: {
			return "future active";
		}
		case FUTURE_PASSIVE: {
			return "future passive";
		}
		case FUTURE_PERFECT: {
			return "future-perfect active";
		}
		case IMPERFECT: {
			return "imperfect active";
		}
		case IMPERFECT_PASSIVE: {
			return "imperfect passive";
		}
		case PERFECT: {
			return "perfect active";
		}
		case PLUPERFECT: {
			return "pluperfect active";
		}
		case PRESENT: {
			return "present active";
		}
		case PRESENT_PASSIVE: {
			return "present passive";
		}
		default: {
			throw new IllegalArgumentException(t.toString());
		}
		}
	}

}
