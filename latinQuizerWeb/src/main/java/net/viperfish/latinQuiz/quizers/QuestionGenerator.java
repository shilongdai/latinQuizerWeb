package net.viperfish.latinQuiz.quizers;

import java.util.List;

import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.Question;
import net.viperfish.latinQuiz.core.Tense;

public interface QuestionGenerator {
	public Question generate(LatinVerb v, Integer[] conjugations, List<Tense> tenses);
}
