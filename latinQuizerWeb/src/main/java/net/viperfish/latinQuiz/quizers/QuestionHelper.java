package net.viperfish.latinQuiz.quizers;

import java.util.ArrayList;
import java.util.List;

final class QuestionHelper {

	private QuestionHelper() {
		// TODO Auto-generated constructor stub
	}

	public static String personToKey(int num) {
		switch (num) {
			case 0: {
				return "first";
			}
			case 1: {
				return "second";
			}
			case 2: {
				return "third";
			}
			default: {
				throw new IllegalArgumentException();
			}
		}
	}

	public static String numberToKey(int num) {
		if (num == 0) {
			return "singular";
		} else {
			return "plural";
		}
	}

	public static <T> List<T> flatten(T[][] src) {
		List<T> result = new ArrayList<>();
		if (src == null) {
			return result;
		}
		for (int i = 0; i < src.length; ++i) {
			for (int j = 0; j < src[i].length; ++j) {
				result.add(src[i][j]);
			}
		}
		return result;

	}

}
