package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class BiConjugator implements Conjugator {

	private Conjugator conj;

	public BiConjugator(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + "bi";
		return conj.inflect(first, stem, t);
	}

}
