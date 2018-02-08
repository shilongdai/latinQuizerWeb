package net.viperfish.latinQuiz.quizers;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.Mood;
import net.viperfish.latinQuiz.core.MultipleChoiceQuestion;
import net.viperfish.latinQuiz.core.Question;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.Voice;

public class MultipleChoiceQuestionGenerator implements QuestionGenerator {

	private MessageSource i18n;
	private SecureRandom rand;

	public MultipleChoiceQuestionGenerator(MessageSource msg) {
		rand = new SecureRandom();
		i18n = msg;
	}

	@Override
	public Question generate(LatinVerb v, Integer[] conjugations, List<Tense> tenses, List<Voice> voices,
			List<Mood> moods) {
		// select and conjugate a random tense, mood, voice
		Tense t = tenses.get(rand.nextInt(tenses.size()));
		Voice randVoice = voices.get(rand.nextInt(voices.size()));
		Mood randMood = moods.get(rand.nextInt(moods.size()));
		String[][] conjugated = v.conjugate(randMood, randVoice, t);
		while (conjugated == null || conjugated.length == 0) {
			t = Tense.values()[rand.nextInt(Tense.values().length)];
			conjugated = v.conjugate(randMood, randVoice, t);
		}
		// select the right answer
		int personIndex = rand.nextInt(conjugated.length);
		int numberIndex = rand.nextInt(conjugated[personIndex].length);

		// generate the question
		String localizedMood = i18n.getMessage(randMood.name(), null, LocaleContextHolder.getLocale());
		String localizedVoice = i18n.getMessage(randVoice.name(), null, LocaleContextHolder.getLocale());
		String localizedTense = i18n.getMessage(t.name(), null, LocaleContextHolder.getLocale());
		String localizedPerson = i18n.getMessage(QuestionHelper.personToKey(personIndex), null,
				LocaleContextHolder.getLocale());
		String localizedNumber = i18n.getMessage(QuestionHelper.numberToKey(numberIndex), null,
				LocaleContextHolder.getLocale());
		String question = i18n
				.getMessage(
						"practice.verb.multipleChoice", new Object[] { v.getDictionaryEntry(), localizedMood,
								localizedVoice, localizedTense, localizedPerson, localizedNumber },
						LocaleContextHolder.getLocale());

		HashSet<String> choices = new HashSet<>();
		String correctChoice = conjugated[personIndex][numberIndex];
		choices.add(correctChoice);
		// create the choices
		generateChoices(v, 4, choices);
		List<String> choiceList = new LinkedList<>(choices);
		Collections.shuffle(choiceList);
		MultipleChoiceQuestion questionResult = createMultipleChoice(question, choiceList, correctChoice);
		return questionResult;
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

	private void generateChoices(LatinVerb v, int amount, Set<String> choices) {
		List<String> mesh = createMesh(v);
		while (choices.size() != amount) {
			choices.add(mesh.get(rand.nextInt(mesh.size())));
		}
	}

	private List<String> createMesh(LatinVerb v) {
		List<String> result = new LinkedList<>();
		for (Mood m : Mood.values()) {
			for (Voice voc : Voice.values()) {
				for (Tense t : Tense.values()) {
					result.addAll(QuestionHelper.flatten(v.conjugate(m, voc, t)));
				}
			}
		}
		return result;
	}

}