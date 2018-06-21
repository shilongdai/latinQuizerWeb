package net.viperfish.latinQuiz.core;

import org.junit.Test;

public class TestFirstDeclintion {

	public TestFirstDeclintion() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testFirstConjF() {
		LatinNoun noun = new LatinNoun("causa", "causae", Gender.F, 0, NounType.REGULAR);
		String[][] supposed = { { "causa", "causae" }, { "causae", "causārum" }, { "causae", "causīs" },
				{ "causam", "causās" }, { "causā", "causīs" } };
		String[][] inflected = noun.inflect();
		TestUtils.test(supposed, inflected);
	}

}
