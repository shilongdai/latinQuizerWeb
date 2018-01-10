package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestThirdIOConjugation {

	@Test
	public void testThirdIOConjugationPresent() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "capio", "capimus" }, { "capis", "capitis" }, { "capit", "capiunt" } };
		String[][] actual = verb.conjugate(Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationImperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "capiebam", "capiebamus" }, { "capiebas", "capiebatis" },
				{ "capiebat", "capiebant" } };
		String[][] actual = verb.conjugate(Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFuture() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "capiam", "capiemus" }, { "capies", "capietis" }, { "capiet", "capient" } };
		String[][] actual = verb.conjugate(Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPerfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "cepi", "cepimus" }, { "cepisti", "cepistis" }, { "cepit", "ceperunt" } };
		String[][] actual = verb.conjugate(Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "ceperam", "ceperamus" }, { "ceperas", "ceperatis" }, { "ceperat", "ceperant" } };
		String[][] actual = verb.conjugate(Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "cepero", "ceperimus" }, { "ceperis", "ceperitis" }, { "ceperit", "ceperint" } };
		String[][] actual = verb.conjugate(Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "capior", "capimur" }, { "caperis", "capimini" }, { "capitur", "capiuntur" } };
		String[][] actual = verb.conjugate(Tense.PRESENT_PASSIVE);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "capiebar", "capiebamur" }, { "capiebaris", "capiebamini" },
				{ "capiebatur", "capiebantur" } };
		String[][] actual = verb.conjugate(Tense.IMPERFECT_PASSIVE);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdIOConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_IO, "capio", "capere", "cepi", "captus");
		String[][] expected = { { "capiar", "capiemur" }, { "capiēris", "capiemini" }, { "capietur", "capientur" } };
		String[][] actual = verb.conjugate(Tense.FUTURE_PASSIVE);
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

}
