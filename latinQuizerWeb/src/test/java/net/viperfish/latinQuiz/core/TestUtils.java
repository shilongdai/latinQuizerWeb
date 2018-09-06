package net.viperfish.latinQuiz.core;

import org.junit.Assert;

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

	public static void test(String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

}
