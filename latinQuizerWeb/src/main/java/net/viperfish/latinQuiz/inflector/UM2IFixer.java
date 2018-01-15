package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class UM2IFixer implements Conjugator {

	private Conjugator conj;

	public UM2IFixer(Conjugator conj) {
		super();
		this.conj = conj;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		for (int i = 0; i < 3; ++i) {
			StringBuilder sb = new StringBuilder(result[i][1]);
			int begin = sb.lastIndexOf("um");
			if (begin != -1) {
				sb.replace(begin, begin + 2, "i");
			}
			result[i][1] = sb.toString();
		}
		return result;
	}

}