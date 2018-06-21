package net.viperfish.latinQuiz.declension;

import net.viperfish.latinQuiz.core.NounDecliner;

public class FirstGenericDeclension implements NounDecliner {

	private String[][] endings = { { "a", "ae" }, { "ae", "ārum" }, { "ae", "īs" }, { "am", "ās" }, { "ā", "īs" } };

	public FirstGenericDeclension() {
	}

	@Override
	public String[][] decline(String first, String stem) {
		String[][] result = new String[endings.length][endings[0].length];
		for (int i = 0; i < endings.length; ++i) {
			for (int j = 0; j < endings[i].length; ++j) {
				result[i][j] = stem + endings[i][j];
			}
		}
		return result;
	}

	private String removeGeneitive(String genitive) {
		return genitive.substring(0, genitive.lastIndexOf(endings[0][1]));
	}

}
