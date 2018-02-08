package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class ConvertToIRule implements VerbRule {

	private VerbRule src;

	public ConvertToIRule(VerbRule src) {
		this.src = src;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		StringBuilder sb = new StringBuilder(stem);
		int begin = sb.lastIndexOf("e");
		sb.setCharAt(begin, 'i');
		return src.inflect(first, sb.toString(), t);
	}

}
