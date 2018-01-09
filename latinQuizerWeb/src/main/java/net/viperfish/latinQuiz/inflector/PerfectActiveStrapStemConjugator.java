package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public final class PerfectActiveStrapStemConjugator implements Conjugator {

	private Conjugator src;

	public PerfectActiveStrapStemConjugator(Conjugator src) {
		this.src = src;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String toConjugate = stem;
		if (stem.charAt(stem.length() - 1) == 'i') {
			toConjugate = stem.substring(0, stem.length() - 1);
		}
		return src.inflect(first, toConjugate, t);
	}

}
