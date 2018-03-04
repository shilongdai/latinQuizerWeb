package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class StemPlusPassiveRule implements VerbRule {

	public StemPlusPassiveRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] endings = { { "r", "mur" }, { "ris", "mini" }, { "tur", "ntur" } };
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
