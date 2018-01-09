package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

// TODO: Optimize
public class IO2OFixer implements Conjugator {

	private Conjugator conj;

	public IO2OFixer(Conjugator c) {
		conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		StringBuilder sb = new StringBuilder(result[0][0]);
		int begin = sb.lastIndexOf("io");
		if (begin == -1) {
			return result;
		}
		sb.replace(begin, begin + 2, "o");
		result[0][0] = sb.toString();

		return result;
	}

}
