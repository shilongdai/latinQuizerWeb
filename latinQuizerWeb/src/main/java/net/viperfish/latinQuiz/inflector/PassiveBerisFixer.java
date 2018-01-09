package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class PassiveBerisFixer implements Conjugator {

	private Conjugator conj;

	public PassiveBerisFixer(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		StringBuilder sb = new StringBuilder(result[1][0]);
		int begin = sb.lastIndexOf("biris");
		if (begin != -1) {
			sb.replace(begin, sb.length(), "beris");
		}
		result[1][0] = sb.toString();
		return result;
	}

}