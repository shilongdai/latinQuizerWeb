package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

abstract class FixerRule implements VerbRule {

	private VerbRule conj;
	private int row;
	private int column;

	public FixerRule(VerbRule c, int row, int column) {
		this.conj = c;
		this.row = row;
		this.column = column;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = conj.inflect(first, stem, t);
		StringBuilder sb = new StringBuilder(result[row][column]);
		fix(sb);
		result[row][column] = sb.toString();
		return result;
	}

	protected abstract void fix(StringBuilder v);

}
