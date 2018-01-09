package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class BaConjugator implements Conjugator {

	private Conjugator conj;

	public BaConjugator(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + "ba";
		return conj.inflect(first, stem, t);
	}

}
