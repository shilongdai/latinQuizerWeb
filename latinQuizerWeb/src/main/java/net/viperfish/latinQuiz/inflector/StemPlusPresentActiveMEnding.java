package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public final class StemPlusPresentActiveMEnding implements VerbRule {

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] endings = { { "m", "mus" }, { "s", "tis" }, { "t", "nt" } };
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
