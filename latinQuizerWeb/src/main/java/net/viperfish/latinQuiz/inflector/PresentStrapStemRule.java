package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbRule;

public final class PresentStrapStemRule implements VerbRule {

	private VerbRule verbRule;

	public PresentStrapStemRule(VerbRule src) {
		this.verbRule = src;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String toInflect = stem;
		if (stem.substring(stem.length() - 2, stem.length()).equalsIgnoreCase("re")) {
			toInflect = toInflect.substring(0, stem.length() - 2);
		}
		String[][] result = verbRule.inflect(first, toInflect, t);
		return result;
	}

}
