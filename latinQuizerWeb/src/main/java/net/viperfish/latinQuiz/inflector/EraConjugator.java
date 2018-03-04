package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class EraConjugator implements VerbRule {

	public EraConjugator() {
	}

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] result = { { "eram", "eramus" }, { "eras", "eratis" }, { "erat", "erant" } };
		return result;
	}

}
