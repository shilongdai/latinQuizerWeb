package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.core.Tense;

public class NullRule implements VerbRule {

	private int row;
	private int column;

	public NullRule(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = new String[row][column];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < column; ++j) {
				result[i][j] = stem;
			}
		}
		return result;
	}

}
