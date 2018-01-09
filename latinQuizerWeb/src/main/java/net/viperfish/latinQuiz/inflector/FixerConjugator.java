package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

abstract class FixerConjugator implements Conjugator {

	private Conjugator conj;
	private int row;
	private int column;

	public FixerConjugator(Conjugator c, int row, int column) {
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
