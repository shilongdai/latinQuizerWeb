package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class SpaceConjugator implements Conjugator {

	private Conjugator c;

	public SpaceConjugator(Conjugator c) {
		super();
		this.c = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + " ";
		return c.inflect(first, stem, t);
	}

}
