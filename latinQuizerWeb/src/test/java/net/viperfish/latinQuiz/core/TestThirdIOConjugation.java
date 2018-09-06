package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestThirdIOConjugation {

	@Test
	public void testThirdIOConjugationPresent() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"capio", "capimus"}, {"capis", "capitis"}, {"capit", "capiunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationImperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"capiebam", "capiebamus"}, {"capiebas", "capiebatis"},
				{"capiebat", "capiebant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFuture() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"capiam", "capiemus"}, {"capies", "capietis"}, {"capiet", "capient"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPerfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"cepi", "cepimus"}, {"cepisti", "cepistis"}, {"cepit", "ceperunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"ceperam", "ceperamus"}, {"ceperas", "ceperatis"},
				{"ceperat", "ceperant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"cepero", "ceperimus"}, {"ceperis", "ceperitis"},
				{"ceperit", "ceperint"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"capior", "capimur"}, {"caperis", "capimini"},
				{"capitur", "capiuntur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"capiebar", "capiebamur"}, {"capiebaris", "capiebamini"},
				{"capiebatur", "capiebantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi",
				"captus",
				VerbType.REGULAR);
		String[][] expected = {{"capiar", "capiemur"}, {"capiēris", "capiemini"},
				{"capietur", "capientur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationDeponentPresent() {
		LatinVerb verb = new LatinVerb(5, "patior", "pati", "passum", "", VerbType.DEPONENT);
		String[][] expected = {{"patior", "patimur"}, {"pateris", "patimini"},
				{"patitur", "patiuntur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationDeponentImperfect() {
		LatinVerb verb = new LatinVerb(5, "patior", "pati", "passum", "", VerbType.DEPONENT);
		String[][] expected = {{"patiebar", "patiebamur"}, {"patiebaris", "patiebamini"},
				{"patiebatur", "patiebantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationDeponentFuture() {
		LatinVerb verb = new LatinVerb(5, "patior", "pati", "passum", "", VerbType.DEPONENT);
		String[][] expected = {{"patiar", "patiemur"}, {"patiēris", "patiemini"},
				{"patietur", "patientur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationDeponentPerfect() {
		LatinVerb verb = new LatinVerb(5, "patior", "pati", "passum", "", VerbType.DEPONENT);
		String[][] expected = {{"passum sum", "passi sumus"}, {"passum es", "passi estis"},
				{"passum est", "passi sunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationDeponentPluperfect() {
		LatinVerb verb = new LatinVerb(5, "patior", "pati", "passum", "", VerbType.DEPONENT);
		String[][] expected = {{"passum eram", "passi eramus"}, {"passum eras", "passi eratis"},
				{"passum erat", "passi erant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationDeponentFutPerf() {
		LatinVerb verb = new LatinVerb(5, "patior", "pati", "passum", "", VerbType.DEPONENT);
		String[][] expected = {{"passum ero", "passi erimus"}, {"passum eris", "passi eritis"},
				{"passum erit", "passi erunt"}};
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
