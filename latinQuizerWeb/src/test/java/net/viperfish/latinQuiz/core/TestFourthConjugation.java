package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestFourthConjugation {

	@Test
	public void testFourthConjugationPresent() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audio", "audimus"}, {"audis", "auditis"}, {"audit", "audiunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationImperfect() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audiebam", "audiebamus"}, {"audiebas", "audiebatis"},
				{"audiebat", "audiebant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationFuture() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audiam", "audiemus"}, {"audies", "audietis"}, {"audiet", "audient"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationPerfect() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audivi", "audivimus"}, {"audivisti", "audivistis"},
				{"audivit", "audiverunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audiveram", "audiveramus"}, {"audiveras", "audiveratis"},
				{"audiverat", "audiverant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audivero", "audiverimus"}, {"audiveris", "audiveritis"},
				{"audiverit", "audiverint"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audior", "audimur"}, {"audiris", "audimini"},
				{"auditur", "audiuntur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audiebar", "audiebamur"}, {"audiebaris", "audiebamini"},
				{"audiebatur", "audiebantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(4, "audio", "audire", "audivi", "auditum", VerbType.REGULAR);
		String[][] expected = {{"audiar", "audiemur"}, {"audieris", "audiemini"},
				{"audietur", "audientur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationDeponentPresent() {
		LatinVerb verb = new LatinVerb(4, "experior", "experiri", "expertum", "", VerbType.DEPONENT);
		String[][] expected = {{"experior", "experimur"}, {"experiris", "experimini"},
				{"experitur", "experiuntur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationDeponentImperfect() {
		LatinVerb verb = new LatinVerb(4, "experior", "experiri", "expertum", "", VerbType.DEPONENT);
		String[][] expected = {{"experiebar", "experiebamur"}, {"experiebaris", "experiebamini"},
				{"experiebatur", "experiebantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationDeponentFuture() {
		LatinVerb verb = new LatinVerb(4, "experior", "experiri", "expertum", "", VerbType.DEPONENT);
		String[][] expected = {{"experiar", "experiemur"}, {"experieris", "experiemini"},
				{"experietur", "experientur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationDeponentPerfect() {
		LatinVerb verb = new LatinVerb(4, "experior", "experiri", "expertum", "", VerbType.DEPONENT);
		String[][] expected = {{"expertum sum", "experti sumus"}, {"expertum es", "experti estis"},
				{"expertum est", "experti sunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationDeponentPluperfect() {
		LatinVerb verb = new LatinVerb(4, "experior", "experiri", "expertum", "", VerbType.DEPONENT);
		String[][] expected = {{"expertum eram", "experti eramus"}, {"expertum eras", "experti eratis"},
				{"expertum erat", "experti erant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationDeponentFutPerf() {
		LatinVerb verb = new LatinVerb(4, "experior", "experiri", "expertum", "", VerbType.DEPONENT);
		String[][] expected = {{"expertum ero", "experti erimus"}, {"expertum eris", "experti eritis"},
				{"expertum erit", "experti erunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT));
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

}
