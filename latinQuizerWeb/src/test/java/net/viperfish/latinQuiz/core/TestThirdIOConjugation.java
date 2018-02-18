package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestThirdIOConjugation {

	@Test
	public void testThirdIOConjugationPresent() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "capio", "capimus" }, { "capis", "capitis" }, { "capit", "capiunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationImperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "capiebam", "capiebamus" }, { "capiebas", "capiebatis" },
				{ "capiebat", "capiebant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFuture() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "capiam", "capiemus" }, { "capies", "capietis" }, { "capiet", "capient" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPerfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "cepi", "cepimus" }, { "cepisti", "cepistis" }, { "cepit", "ceperunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "ceperam", "ceperamus" }, { "ceperas", "ceperatis" }, { "ceperat", "ceperant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "cepero", "ceperimus" }, { "ceperis", "ceperitis" }, { "ceperit", "ceperint" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "capior", "capimur" }, { "caperis", "capimini" }, { "capitur", "capiuntur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "capiebar", "capiebamur" }, { "capiebaris", "capiebamini" },
				{ "capiebatur", "capiebantur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus",
				VerbType.REGULAR);
		String[][] expected = { { "capiar", "capiemur" }, { "capiēris", "capiemini" }, { "capietur", "capientur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE);
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

}
