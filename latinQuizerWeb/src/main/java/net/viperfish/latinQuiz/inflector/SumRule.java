package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class SumRule implements VerbRule {

	public SumRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] results = { { "sum", "sumus" }, { "es", "estis" }, { "est", "sunt" } };
		return results;
	}

}
