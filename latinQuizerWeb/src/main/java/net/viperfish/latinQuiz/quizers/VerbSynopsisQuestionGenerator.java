package net.viperfish.latinQuiz.quizers;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.Mood;
import net.viperfish.latinQuiz.core.Question;
import net.viperfish.latinQuiz.core.SynopsisAnswer;
import net.viperfish.latinQuiz.core.SynopsisQuestion;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.Voice;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class VerbSynopsisQuestionGenerator implements VerbQuestionGenerator {

	private SecureRandom rand;
	private MessageSource i18n;

	public VerbSynopsisQuestionGenerator(MessageSource source) {
		rand = new SecureRandom();
		this.i18n = source;
	}

	@Override
	public Question generate(LatinVerb v, Integer[] conjugations, List<Tense> tenses,
			List<Voice> voices,
			List<Mood> moods) {
		SynopsisQuestion questionResult = new SynopsisQuestion();
		SynopsisAnswer answer = new SynopsisAnswer();
		Voice randVoice = null;
		Mood randMood = null;
		int person = 0;
		int sgPl = 0;
		while (questionResult.getTenses().size() == 0) {
			randVoice = voices.get(rand.nextInt(voices.size()));
			randMood = moods.get(rand.nextInt(moods.size()));
			person = rand.nextInt(3);
			sgPl = rand.nextInt(2);
			for (Tense t : tenses) {
				ConjugatedVerb[][] conjugated = v.conjugate(randMood, randVoice, t);
				if (conjugated.length != 0) {
					questionResult.getTenses().add(t);
					answer.getRows().put(t, conjugated[person][sgPl].getConjugated());
					questionResult.getSteps().put(t, new LinkedList<Triple<String, List<String>, String>>(
							conjugated[person][sgPl].getInterProduct()));
				}
			}
		}

		// generate the question
		String localizedMood = i18n.getMessage(randMood.name(), null, LocaleContextHolder.getLocale());
		String localizedVoice = i18n
				.getMessage(randVoice.name(), null, LocaleContextHolder.getLocale());
		String localizedPerson = i18n.getMessage(QuestionHelper.personToKey(person), null,
				LocaleContextHolder.getLocale());
		String localizedNumber = i18n.getMessage(QuestionHelper.numberToKey(sgPl), null,
				LocaleContextHolder.getLocale());
		String question = i18n.getMessage("practice.verb.synopsis", new Object[]{v.getDictionaryEntry(),
						localizedMood, localizedVoice, localizedPerson, localizedNumber},
				LocaleContextHolder.getLocale());

		questionResult.setQuestion(question);
		questionResult.setAnswer(answer);
		return questionResult;
	}

}
