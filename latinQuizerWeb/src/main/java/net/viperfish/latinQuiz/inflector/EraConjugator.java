package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class EraConjugator implements Conjugator {

	public EraConjugator() {
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = { { "eram", "eramus" }, { "eras", "eratis" }, { "erat", "erant" } };
		return result;
	}

}
