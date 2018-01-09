package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class PassivePresentFixer implements Conjugator {

	private Conjugator conj;

	public PassivePresentFixer(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		result[0][0] = first + "r";
		return result;
	}

}
