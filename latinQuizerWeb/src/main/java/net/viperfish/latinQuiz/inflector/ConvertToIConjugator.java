package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class ConvertToIConjugator implements Conjugator {

	private Conjugator src;

	public ConvertToIConjugator(Conjugator src) {
		this.src = src;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem = stem.substring(0, stem.length() - 1) + "i";
		return src.inflect(first, stem, t);
	}

}
