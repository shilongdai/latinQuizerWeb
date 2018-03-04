package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public final class EssemRule implements VerbRule {

	public EssemRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] results = { { "essem", "essemus" }, { "esses", "essetis" }, { "esset", "essent" } };
		return results;
	}

}
