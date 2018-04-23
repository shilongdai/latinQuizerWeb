package net.viperfish.latinQuiz.core;

public final class TestUtils {
	public static String[][] conjVerb2StringArray(ConjugatedVerb[][] array) {
		String[][] result = new String[array.length][];
		for (int i = 0; i < result.length; ++i) {
			result[i] = new String[array[i].length];
			for (int j = 0; j < result[i].length; ++j) {
				result[i][j] = array[i][j].getConjugated();
			}
		}
		return result;
	}
}
