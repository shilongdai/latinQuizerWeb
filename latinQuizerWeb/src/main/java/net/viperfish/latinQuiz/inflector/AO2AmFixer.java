package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

// TODO: Optimize
public class AO2AmFixer implements Conjugator {

	private Conjugator conj;

	public AO2AmFixer(Conjugator c) {
		this.conj = c;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		StringBuilder sb = new StringBuilder(result[0][0]);
		int begin = sb.lastIndexOf("ao");
		if (begin == -1) {
			return result;
		}
		sb.replace(begin, begin + 2, "am");
		result[0][0] = sb.toString();
		return result;
	}

}
