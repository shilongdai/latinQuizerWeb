package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class StemPlusPerfectActiveEndingsConjugator implements Conjugator {

	public StemPlusPerfectActiveEndingsConjugator() {
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] endings = { { "i", "imus" }, { "isti", "itis" }, { "it", "erunt" } };
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
