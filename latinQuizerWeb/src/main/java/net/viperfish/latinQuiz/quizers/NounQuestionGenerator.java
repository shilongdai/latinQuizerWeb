package net.viperfish.latinQuiz.quizers;

import java.util.List;

import net.viperfish.latinQuiz.core.Gender;
import net.viperfish.latinQuiz.core.LatinNoun;
import net.viperfish.latinQuiz.core.NounType;
import net.viperfish.latinQuiz.core.Question;

public interface NounQuestionGenerator {
	public Question generate(LatinNoun n, Integer[] declinsions, List<Gender> genders, List<NounType> types);
}
