package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class CombiningRules implements VerbRule {

	private VerbRule first;
	private VerbRule second;
	private String seperator;

	public CombiningRules(VerbRule first, String seperator, VerbRule second) {
		this.first = first;
		this.second = second;
		this.seperator = seperator;
	}

	@Override
	public String[][] inflect(String first, String stem) {
		String[][] result1 = this.first.inflect(first, stem);
		String[][] result2 = this.second.inflect(first, stem);
		for (int i = 0; i < result1.length; ++i) {
			for (int j = 0; j < result1[i].length; ++j) {
				result2[i][j] = result1[i][j] + seperator + result2[i][j];
			}
		}
		return result2;
	}

}
