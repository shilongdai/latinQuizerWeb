package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public final class PresentStrapStemConjugator implements Conjugator {

	private Conjugator conjugator;

	public PresentStrapStemConjugator(Conjugator src) {
		this.conjugator = src;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String toInflect = stem;
		if (stem.substring(stem.length() - 2, stem.length()).equalsIgnoreCase("re")) {
			toInflect = toInflect.substring(0, stem.length() - 2);
		}
		String[][] result = conjugator.inflect(first, toInflect, t);
		if (t == Tense.PRESENT) {
			result[0][0] = first;
		}
		if (t == Tense.PRESENT_PASSIVE) {
			result[0][0] = first + 'r';
		}
		return result;
	}

}
