package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class EriConjugator implements Conjugator {

	private Conjugator conj;

	public EriConjugator(Conjugator c) {
		conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + "eri";
		return conj.inflect(first, stem, t);
	}

}
