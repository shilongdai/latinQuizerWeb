package net.viperfish.latinQuiz.quizers;

import java.util.List;

import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.Mood;
import net.viperfish.latinQuiz.core.Question;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.Voice;

public interface VerbQuestionGenerator {
	public Question generate(LatinVerb v, Integer[] conjugations, List<Tense> tenses, List<Voice> voices,
			List<Mood> moods);
}
