package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class CombiningConjugator implements Conjugator {

	private Conjugator first;
	private Conjugator second;
	private String seperator;

	public CombiningConjugator(Conjugator first, String seperator, Conjugator second) {
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
