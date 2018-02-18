package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestThirdOConjugation {

	@Test
	public void testThirdOConjugationPresent() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "duco", "ducimus" }, { "ducis", "ducitis" }, { "ducit", "ducunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationImperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "ducebam", "ducebamus" }, { "ducebas", "ducebatis" }, { "ducebat", "ducebant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationFuture() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "ducam", "ducemus" }, { "duces", "ducetis" }, { "ducet", "ducent" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationPerfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "duxi", "duximus" }, { "duxisti", "duxistis" }, { "duxit", "duxerunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "duxeram", "duxeramus" }, { "duxeras", "duxeratis" }, { "duxerat", "duxerant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "duxero", "duxerimus" }, { "duxeris", "duxeritis" }, { "duxerit", "duxerint" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "ducor", "ducimur" }, { "duceris", "ducimini" }, { "ducitur", "ducuntur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "ducebar", "ducebamur" }, { "ducebaris", "ducebamini" },
				{ "ducebatur", "ducebantur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testThirdOConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(ConjugationMapper.THIRD_CONJ_O, "duco", "ducere", "duxi", "ductus",
				VerbType.REGULAR);
		String[][] expected = { { "ducar", "ducemur" }, { "ducēris", "ducemini" }, { "ducetur", "ducentur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE);
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}
}
