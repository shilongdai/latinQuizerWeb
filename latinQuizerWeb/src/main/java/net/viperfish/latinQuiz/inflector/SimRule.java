package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class SimRule implements VerbRule {

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] result = { { "sim", "simus" }, { "sis", "sitis" }, { "sit", "sint" } };
		return result;
	}

}
