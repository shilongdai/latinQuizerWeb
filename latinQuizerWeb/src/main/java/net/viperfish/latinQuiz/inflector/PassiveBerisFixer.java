package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class PassiveBerisFixer implements VerbRule {

	private VerbRule conj;

	public PassiveBerisFixer(VerbRule c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] result = conj.inflect(first, stem);
		StringBuilder sb = new StringBuilder(result[1][0]);
		int begin = sb.lastIndexOf("biris");
		if (begin != -1) {
			sb.replace(begin, sb.length(), "beris");
		}
		result[1][0] = sb.toString();
		return result;
	}

}
