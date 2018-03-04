package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbRule;

abstract class ReplaceLastRule implements VerbRule {

	private VerbRule conj;
	private int row;
	private int column;
	private String toReplace;
	private String replacement;

	public ReplaceLastRule(VerbRule c, int row, int column, String toReplace, String replacement) {
		this.conj = c;
		this.row = row;
		this.column = column;
		this.toReplace = toReplace;
		this.replacement = replacement;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		StringBuilder sb = new StringBuilder(result[row][column]);

		int begin = sb.lastIndexOf(toReplace);
		if (begin != -1) {
			sb.replace(begin, begin + toReplace.length(), replacement);
		}

		result[row][column] = sb.toString();
		return result;
	}

}
