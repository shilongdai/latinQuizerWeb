package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestFirstConjugations {
	@Test
	public void testFirstConjugationPresent() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogito", "cogitamus" }, { "cogitas", "cogitatis" }, { "cogitat", "cogitant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT);
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	public void testFirstConjugationImperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitabam", "cogitabamus" }, { "cogitabas", "cogitabatis" },
				{ "cogitabat", "cogitabant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFuture() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitabo", "cogitabimus" }, { "cogitabis", "cogitabitis" },
				{ "cogitabit", "cogitabunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPerfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitavi", "cogitavimus" }, { "cogitavisti", "cogitavistis" },
				{ "cogitavit", "cogitaverunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitaveram", "cogitaveramus" }, { "cogitaveras", "cogitaveratis" },
				{ "cogitaverat", "cogitaverant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitavero", "cogitaverimus" }, { "cogitaveris", "cogitaveritis" },
				{ "cogitaverit", "cogitaverint" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitor", "cogitamur" }, { "cogitaris", "cogitamini" },
				{ "cogitatur", "cogitantur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitabar", "cogitabamur" }, { "cogitabaris", "cogitabamini" },
				{ "cogitabatur", "cogitabantur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus", VerbType.REGULAR);
		String[][] expected = { { "cogitabor", "cogitabimur" }, { "cogitaberis", "cogitabimini" },
				{ "cogitabitur", "cogitabuntur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPerfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum", VerbType.REGULAR);
		String[][] expected = { { "cogitatum sum", "cogitati sumus" }, { "cogitatum es", "cogitati estis" },
				{ "cogitatum est", "cogitati sunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPluperfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum", VerbType.REGULAR);
		String[][] expected = { { "cogitatum eram", "cogitati eramus" }, { "cogitatum eras", "cogitati eratis" },
				{ "cogitatum erat", "cogitati erant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFutureperfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum", VerbType.REGULAR);
		String[][] expected = { { "cogitatum ero", "cogitati erimus" }, { "cogitatum eris", "cogitati eritis" },
				{ "cogitatum erit", "cogitati erunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentPresent() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "", VerbType.DEPONENT);
		String[][] expected = { { "conspicior", "conspicamur" }, { "conspicaris", "conspicamini" },
				{ "conspicatur", "conspicantur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentImperfect() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "", VerbType.DEPONENT);
		String[][] expected = { { "conspicabar", "conspicabamur" }, { "conspicabaris", "conspicabamini" },
				{ "conspicabatur", "conspicabantur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentFuture() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "", VerbType.DEPONENT);
		String[][] expected = { { "conspicabor", "conspicabimur" }, { "conspicaberis", "conspicabimini" },
				{ "conspicabitur", "conspicabuntur" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentPerfect() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "", VerbType.DEPONENT);
		String[][] expected = { { "conspicatum sum", "conspicati sumus" }, { "conspicatum es", "conspicati estis" },
				{ "conspicatum est", "conspicati sunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentPluperfect() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "", VerbType.DEPONENT);
		String[][] expected = { { "conspicatum eram", "conspicati eramus" },
				{ "conspicatum eras", "conspicati eratis" }, { "conspicatum erat", "conspicati erant" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT);
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentFutPerf() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "", VerbType.DEPONENT);
		String[][] expected = { { "conspicatum ero", "conspicati erimus" }, { "conspicatum eris", "conspicati eritis" },
				{ "conspicatum erit", "conspicati erunt" } };
		String[][] actual = verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT);
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}
}
