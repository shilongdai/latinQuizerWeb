package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class IR2ORFixer implements Conjugator {

	private Conjugator conj;

	public IR2ORFixer(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		StringBuilder sb = new StringBuilder(result[0][0]);
		int begin = sb.lastIndexOf("ir");
		if (begin == -1) {
			return result;
		}
		sb.replace(begin, begin + 2, "or");
		result[0][0] = sb.toString();

		return result;
	}

}
