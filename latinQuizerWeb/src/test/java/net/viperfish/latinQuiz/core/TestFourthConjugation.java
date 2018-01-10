package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestFourthConjugation {

	@Test
	public void testFourthConjugationPresent() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audio", "audimus" }, { "audis", "auditis" }, { "audit", "audiunt" } };
		String[][] actual = verb.conjugate(Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationImperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audiebam", "audiebamus" }, { "audiebas", "audiebatis" },
				{ "audiebat", "audiebant" } };
		String[][] actual = verb.conjugate(Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationFuture() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audiam", "audiemus" }, { "audies", "audietis" }, { "audiet", "audient" } };
		String[][] actual = verb.conjugate(Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationPerfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audivi", "audivimus" }, { "audivisti", "audivistis" }, { "audivit", "audiverunt" } };
		String[][] actual = verb.conjugate(Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audiveram", "audiveramus" }, { "audiveras", "audiveratis" },
				{ "audiverat", "audiverant" } };
		String[][] actual = verb.conjugate(Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFourthConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audivero", "audiverimus" }, { "audiveris", "audiveritis" },
				{ "audiverit", "audiverint" } };
		String[][] actual = verb.conjugate(Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audior", "audimur" }, { "audiris", "audimini" }, { "auditur", "audiuntur" } };
		String[][] actual = verb.conjugate(Tense.PRESENT_PASSIVE);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audiebar", "audiebamur" }, { "audiebaris", "audiebamini" },
				{ "audiebatur", "audiebantur" } };
		String[][] actual = verb.conjugate(Tense.IMPERFECT_PASSIVE);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.FOURTH_CONJ, "audio", "audire", "audivi", "auditus");
		String[][] expected = { { "audiar", "audiemur" }, { "audieris", "audiemini" }, { "audietur", "audientur" } };
		String[][] actual = verb.conjugate(Tense.FUTURE_PASSIVE);
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

}
