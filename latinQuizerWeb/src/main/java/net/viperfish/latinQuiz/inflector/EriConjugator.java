package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class EriConjugator implements VerbRule {

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = { { "ero", "erimus" }, { "eris", "eritis" }, { "erit", "erint" } };
		return result;
	}

}
