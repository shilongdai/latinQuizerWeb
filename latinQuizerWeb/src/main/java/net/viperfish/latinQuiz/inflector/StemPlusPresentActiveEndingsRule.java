package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class StemPlusPresentActiveEndingsRule implements VerbRule {

	public StemPlusPresentActiveEndingsRule() {
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] endings = { { "o", "mus" }, { "s", "tis" }, { "t", "nt" } };
		String[][] result = new String[endings.length][];
		for (int i = 0; i < result.length; ++i) {
			result[i] = new String[endings[i].length];
		}
		for (int i = 0; i < endings.length; ++i) {
			for (int j = 0; j < endings[i].length; ++j) {
				result[i][j] = stem + endings[i][j];
			}
		}
		return result;
	}

}
