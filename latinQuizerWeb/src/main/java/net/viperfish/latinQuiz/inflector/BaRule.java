package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class BaRule implements VerbRule {

	private VerbRule conj;

	public BaRule(VerbRule c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + "ba";
		return conj.inflect(first, stem, t);
	}

}
