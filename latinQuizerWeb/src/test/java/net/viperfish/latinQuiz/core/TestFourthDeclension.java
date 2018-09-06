package net.viperfish.latinQuiz.core;

import org.junit.Test;

public class TestFourthDeclension {

	@Test
	public void testFourthDeclensionMasculine() {
		LatinNoun noun = new LatinNoun("cursus", "cursūs", Gender.M, 3, NounType.REGULAR);
		String[][] expected = {{"cursus", "cursūs"}, {"cursūs", "cursuum"}, {"cursuī", "cursibus"},
				{"cursum", "cursūs"}, {"cursū", "cursibus"}};
		String[][] inflected = noun.inflect();
		TestUtils.test(expected, inflected);
	}

	@Test
	public void testFourthDeclensionNeuter() {
		LatinNoun noun = new LatinNoun("cornū", "cornūs", Gender.N, 3, NounType.REGULAR);
		String[][] expected = {{"cornū", "cornua"}, {"cornūs", "cornuum"}, {"cornū", "cornibus"},
				{"cornū", "cornua"}, {"cornū", "cornibus"}};
		String[][] inflected = noun.inflect();
		TestUtils.test(expected, inflected);
	}

}
