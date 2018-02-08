package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

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
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result1 = this.first.inflect(first, stem, t);
		String[][] result2 = this.second.inflect(first, stem, t);
		for (int i = 0; i < result1.length; ++i) {
			for (int j = 0; j < result1[i].length; ++j) {
				result2[i][j] = result1[i][j] + seperator + result2[i][j];
			}
		}
		return result2;
	}

}
