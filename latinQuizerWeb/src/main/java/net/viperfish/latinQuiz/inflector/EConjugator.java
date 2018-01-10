package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class EConjugator implements Conjugator {

	private Conjugator conj;

	public EConjugator(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + "e";
		return conj.inflect(first, stem, t);
	}

}
