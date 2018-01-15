package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

public class NullConjugator implements Conjugator {

	private int row;
	private int column;

	public NullConjugator(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] result = new String[row][column];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < column; ++j) {
				System.out.printf("row:%d column: %d\n", i, j);
				result[i][j] = stem;
			}
		}
		return result;
	}

}
