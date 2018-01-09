package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestFirstConjugations {
	@Test
	public void testFirstConjugationPresent() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogito", "cogitamus" }, { "cogitas", "cogitatis" }, { "cogitat", "cogitant" } };
		String[][] actual = verb.conjugate(Tense.PRESENT);
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	public void testFirstConjugationImperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitabam", "cogitabamus" }, { "cogitabas", "cogitabatis" },
				{ "cogitabat", "cogitabant" } };
		String[][] actual = verb.conjugate(Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFuture() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitabo", "cogitabimus" }, { "cogitabis", "cogitabitis" },
				{ "cogitabit", "cogitabunt" } };
		String[][] actual = verb.conjugate(Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPerfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitavi", "cogitavimus" }, { "cogitavisti", "cogitavistis" },
				{ "cogitavit", "cogitaverunt" } };
		String[][] actual = verb.conjugate(Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitaveram", "cogitaveramus" }, { "cogitaveras", "cogitaveratis" },
				{ "cogitaverat", "cogitaverant" } };
		String[][] actual = verb.conjugate(Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitavero", "cogitaverimus" }, { "cogitaveris", "cogitaveritis" },
				{ "cogitaverit", "cogitaverint" } };
		String[][] actual = verb.conjugate(Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitor", "cogitamur" }, { "cogitaris", "cogitamini" },
				{ "cogitatur", "cogitantur" } };
		String[][] actual = verb.conjugate(Tense.PRESENT_PASSIVE);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitabar", "cogitabamur" }, { "cogitabaris", "cogitabamini" },
				{ "cogitabatur", "cogitabantur" } };
		String[][] actual = verb.conjugate(Tense.IMPERFECT_PASSIVE);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus");
		String[][] expected = { { "cogitabor", "cogitabimur" }, { "cogitaberis", "cogitabimini" },
				{ "cogitabitur", "cogitabuntur" } };
		String[][] actual = verb.conjugate(Tense.FUTURE_PASSIVE);
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}
}
