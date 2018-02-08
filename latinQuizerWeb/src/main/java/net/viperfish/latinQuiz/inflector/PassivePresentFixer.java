package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class PassivePresentFixer implements VerbRule {

	private VerbRule conj;

	public PassivePresentFixer(VerbRule c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		result[0][0] = first + "r";
		return result;
	}

}
