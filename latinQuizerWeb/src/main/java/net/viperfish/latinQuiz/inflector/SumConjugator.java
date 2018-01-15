package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class SumConjugator implements Conjugator {

	public SumConjugator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] results = { { "sum", "sumus" }, { "es", "estis" }, { "est", "sunt" } };
		return results;
	}

}
