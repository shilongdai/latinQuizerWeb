package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class EraConjugator implements Conjugator {

	private Conjugator conj;

	public EraConjugator(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem + "era";
		return conj.inflect(first, stem, t);
	}

}
