package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class SpaceRule implements VerbRule {

	private VerbRule c;

	public SpaceRule(VerbRule c) {
		super();
		this.c = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + " ";
		return c.inflect(first, stem, t);
	}

}
