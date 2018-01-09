package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

// TODO: Optimize
public class Int2UntFixer implements Conjugator {

	private Conjugator src;

	public Int2UntFixer(Conjugator src) {
		this.src = src;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = src.inflect(first, stem, t);
		StringBuilder sb = new StringBuilder(result[2][1]);
		int begin = sb.lastIndexOf("int");
		if (begin != -1) {
			sb.replace(begin, begin + 3, "unt");
			result[2][1] = sb.toString();
		}

		return result;
	}

}
