package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class TestFirstConjugations {

	@Test
	public void testFirstConjugationPresent() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogito", "cogitamus"}, {"cogitas", "cogitatis"},
				{"cogitat", "cogitant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT));
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	public void testFirstConjugationImperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitabam", "cogitabamus"}, {"cogitabas", "cogitabatis"},
				{"cogitabat", "cogitabant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFuture() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitabo", "cogitabimus"}, {"cogitabis", "cogitabitis"},
				{"cogitabit", "cogitabunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPerfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitavi", "cogitavimus"}, {"cogitavisti", "cogitavistis"},
				{"cogitavit", "cogitaverunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPluperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitaveram", "cogitaveramus"}, {"cogitaveras", "cogitaveratis"},
				{"cogitaverat", "cogitaverant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFutureperfect() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitavero", "cogitaverimus"}, {"cogitaveris", "cogitaveritis"},
				{"cogitaverit", "cogitaverint"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPresentPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitor", "cogitamur"}, {"cogitaris", "cogitamini"},
				{"cogitatur", "cogitantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationImperfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitabar", "cogitabamur"}, {"cogitabaris", "cogitabamini"},
				{"cogitabatur", "cogitabantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFuturePassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitabor", "cogitabimur"}, {"cogitaberis", "cogitabimini"},
				{"cogitabitur", "cogitabuntur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPerfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum",
				VerbType.REGULAR);
		String[][] expected = {{"cogitatum sum", "cogitati sumus"}, {"cogitatum es", "cogitati estis"},
				{"cogitatum est", "cogitati sunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPluperfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum",
				VerbType.REGULAR);
		String[][] expected = {{"cogitatum eram", "cogitati eramus"},
				{"cogitatum eras", "cogitati eratis"},
				{"cogitatum erat", "cogitati erant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationFutureperfectPassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum",
				VerbType.REGULAR);
		String[][] expected = {{"cogitatum ero", "cogitati erimus"},
				{"cogitatum eris", "cogitati eritis"},
				{"cogitatum erit", "cogitati erunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.PASSIVE, Tense.FUTURE_PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentPresent() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "",
				VerbType.DEPONENT);
		String[][] expected = {{"conspicior", "conspicamur"}, {"conspicaris", "conspicamini"},
				{"conspicatur", "conspicantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentImperfect() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "",
				VerbType.DEPONENT);
		String[][] expected = {{"conspicabar", "conspicabamur"}, {"conspicabaris", "conspicabamini"},
				{"conspicabatur", "conspicabantur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentFuture() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "",
				VerbType.DEPONENT);
		String[][] expected = {{"conspicabor", "conspicabimur"}, {"conspicaberis", "conspicabimini"},
				{"conspicabitur", "conspicabuntur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentPerfect() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "",
				VerbType.DEPONENT);
		String[][] expected = {{"conspicatum sum", "conspicati sumus"},
				{"conspicatum es", "conspicati estis"},
				{"conspicatum est", "conspicati sunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentPluperfect() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "",
				VerbType.DEPONENT);
		String[][] expected = {{"conspicatum eram", "conspicati eramus"},
				{"conspicatum eras", "conspicati eratis"}, {"conspicatum erat", "conspicati erant"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationDeponentFutPerf() {
		LatinVerb verb = new LatinVerb(1, "conspicior", "conspicari", "conspicatum", "",
				VerbType.DEPONENT);
		String[][] expected = {{"conspicatum ero", "conspicati erimus"},
				{"conspicatum eris", "conspicati eritis"},
				{"conspicatum erit", "conspicati erunt"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.INDICATIVE, Voice.ACTIVE, Tense.FUTURE_PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationImperfectSubjunctive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitarem", "cogitaremus"}, {"cogitares", "cogitaretis"},
				{"cogitaret", "cogitarent"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.ACTIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPresentSubjunctive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitem", "cogitemus"}, {"cogites", "cogitetis"},
				{"cogitet", "cogitent"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.ACTIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPerfectSubjunctive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitaverim", "cogitaverimus"}, {"cogitaveris", "cogitaveritis"},
				{"cogitaverit", "cogitaverint"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.ACTIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPluPerfectSubjunctive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitavissem", "cogitavissemus"}, {"cogitavisses", "cogitavissetis"},
				{"cogitavisset", "cogitavissent"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.ACTIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationImperfectSubjunctivePassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogitarer", "cogitaremur"}, {"cogitareris", "cogitaremini"},
				{"cogitaretur", "cogitarentur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.PASSIVE, Tense.IMPERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPresentSubjunctivePassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatus",
				VerbType.REGULAR);
		String[][] expected = {{"cogiter", "cogitemur"}, {"cogiteris", "cogitemini"},
				{"cogitetur", "cogitentur"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.PASSIVE, Tense.PRESENT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPerfectSubjunctivePassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum",
				VerbType.REGULAR);
		String[][] expected = {{"cogitatum sim", "cogitati simus"}, {"cogitatum sis", "cogitati sitis"},
				{"cogitatum sit", "cogitati sint"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.PASSIVE, Tense.PERFECT));
		test(verb, expected, actual);
	}

	@Test
	public void testFirstConjugationPluPerfectSubjunctivePassive() {
		LatinVerb verb = new LatinVerb(1, "cogito", "cogitare", "cogitavi", "cogitatum",
				VerbType.REGULAR);
		String[][] expected = {{"cogitatum essem", "cogitati essemus"},
				{"cogitatum esses", "cogitati essetis"},
				{"cogitatum esset", "cogitati essent"}};
		String[][] actual = TestUtils
				.conjVerb2StringArray(verb.conjugate(Mood.SUBJUNCTIVE, Voice.PASSIVE, Tense.PLUPERFECT));
		test(verb, expected, actual);
	}

	private void test(LatinVerb verb, String[][] expected, String[][] actual) {
		for (int i = 0; i < 3; ++i) {
			Assert.assertArrayEquals(expected[i], actual[i]);
		}
	}
}
