package net.viperfish.latinQuiz.quizers;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import net.viperfish.latinQuiz.core.Gender;
import net.viperfish.latinQuiz.core.LatinNoun;
import net.viperfish.latinQuiz.core.MultipleChoiceQuestion;
import net.viperfish.latinQuiz.core.NounType;
import net.viperfish.latinQuiz.core.Question;

public final class NounMultipleChoiceQuestionGenerator implements NounQuestionGenerator {

	private SecureRandom rand;
	private MessageSource i18n;

	public NounMultipleChoiceQuestionGenerator(MessageSource i18n) {
		this.i18n = i18n;
		this.rand = new SecureRandom();
	}

	@Override
	public Question generate(LatinNoun n, Integer[] declinsions, List<Gender> genders, List<NounType> types) {
		// choose a form of the noun
		int grammerPart = rand.nextInt(5);
		int number = rand.nextInt(2);

		// generate correct answer
		String[][] declined = n.inflect();
		String correctChoice = declined[grammerPart][number];

		// generate the question
		String localizedCase = i18n.getMessage(caseToKey(grammerPart), null, LocaleContextHolder.getLocale());
		String localizedNumber = i18n.getMessage(QuestionHelper.numberToKey(number), null,
				LocaleContextHolder.getLocale());
		String question = i18n
				.getMessage(
						"practice.noun.multipleChoice", new Object[] { n.getNomSing(), n.getGenitive(),
								n.getGender().toString(), localizedCase, localizedNumber },
						LocaleContextHolder.getLocale());

		// generate all other choices;
		Set<String> choices = new HashSet<>();
		choices.add(correctChoice);

		// generate the "related" choices
		// CURRENTLY SKIPPING b/c not enough declension implemented
		LogManager.getLogger().warn("generating related choice");
		while (choices.size() < 1) {
			String related = null;
			while (related == null) {
				int dec = declinsions[rand.nextInt(declinsions.length)];
				Gender g = genders.get(rand.nextInt(genders.size()));
				NounType t = types.get(rand.nextInt(types.size()));
				related = n.inflect(dec, g, t)[grammerPart][number];
			}
			choices.add(related);
		}
		// generate the "unrelated" choice
		String unrelated = "";
		LogManager.getLogger().warn("generating unrelated choice");
		do {
			grammerPart = rand.nextInt(5);
			number = rand.nextInt(2);
			int dec = declinsions[rand.nextInt(declinsions.length)];
			Gender g = genders.get(rand.nextInt(genders.size()));
			NounType t = types.get(rand.nextInt(types.size()));
			unrelated = n.inflect(dec, g, t)[grammerPart][number];
		} while (unrelated.equals(correctChoice) && choices.contains(unrelated));
		choices.add(unrelated);
		List<String> choiceShuffled = new LinkedList<String>();
		for (String i : choices) {
			choiceShuffled.add(i);
		}
		Collections.shuffle(choiceShuffled);

		MultipleChoiceQuestion result = new MultipleChoiceQuestion(question);
		for (String i : choiceShuffled) {
			if (i.equals(correctChoice)) {
				result.addChoice(i, true);
			} else {
				result.addChoice(i, false);
			}
		}
		return result;

	}

	private String caseToKey(int dec) {
		switch (dec) {
		case 0:
			return "nominative";
		case 1:
			return "genitive";
		case 2:
			return "dative";
		case 3:
			return "accusative";
		case 4:
			return "ablative";
		}
		return "";
	}

}
