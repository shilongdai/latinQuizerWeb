package net.viperfish.latinQuiz.core;

import org.junit.Test;

public class TestSecondDeclension {

	@Test
	public void testSecondMNoun() {
		LatinNoun noun = new LatinNoun("ager", "agrī", Gender.M, 1, NounType.REGULAR);
		String[][] expected = new String[][]{{"ager", "agrī"}, {"agrī", "agrōrum"}, {"agrō", "agrīs"},
				{"agrum", "agrōs"}, {"agrō", "agrīs"}};
		String[][] inflected = noun.inflect();

		TestUtils.test(expected, inflected);
	}

	@Test
	public void testSecondNNoun() {
		LatinNoun noun = new LatinNoun("vinum", "vinī", Gender.N, 1, NounType.REGULAR);
		String[][] expected = new String[][]{{"vinum", "vina"}, {"vinī", "vinōrum"}, {"vinō", "vinīs"},
				{"vinum", "vina"}, {"vinō", "vinīs"}};
		String[][] inflected = noun.inflect();

		TestUtils.test(expected, inflected);
	}

}
