package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class ERule implements VerbRule {

	private VerbRule conj;

	public ERule(VerbRule c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + "e";
		return conj.inflect(first, stem, t);
	}

}
