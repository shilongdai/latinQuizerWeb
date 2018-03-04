package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class EriConjugator implements VerbRule {

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] result = { { "ero", "erimus" }, { "eris", "eritis" }, { "erit", "erint" } };
		return result;
	}

}
