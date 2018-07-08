package net.viperfish.latinQuiz.declension;

import net.viperfish.latinQuiz.core.NounDecliner;

public class Declension implements NounDecliner {

	private String[][] endings;

	public Declension(String[][] endings) {
		this.endings = endings;
	}

	@Override
	public String[][] decline(String first, String stem) {
		String[][] result = new String[endings.length][endings[0].length];
		for (int i = 0; i < endings.length; ++i) {
			for (int j = 0; j < endings[i].length; ++j) {
				result[i][j] = stem + endings[i][j];
			}
		}
		result[0][0] = first;
		return result;
	}

}
