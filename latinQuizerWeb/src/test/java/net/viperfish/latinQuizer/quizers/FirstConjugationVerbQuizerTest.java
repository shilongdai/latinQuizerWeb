package net.viperfish.latinQuizer.quizers;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.MultipleChoiceQuestion;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.errors.InsufficientWordBankException;
import net.viperfish.latinQuiz.quizers.VerbQuizerService;

public class FirstConjugationVerbQuizerTest {

	private static MockLatinVerbDatabase db;

	@BeforeClass
	public static void createTestFiles() throws IOException {
		db = new MockLatinVerbDatabase();
		db.save(new LatinVerb(1, "cogito", "cogitare", "cogitare", "cogitatus"));
		db.save(new LatinVerb(2, "moneo", "monere", "monui", "monitus"));
		db.save(new LatinVerb(1, "amo", "amare", "amavi", "amatus"));
		db.save(new LatinVerb(1, "erro", "errare", "erravi", "erratus"));
		db.save(new LatinVerb(1, "do", "dare", "dedi", "datus"));
	}

	@Test
	public void testRegular() throws IOException, InsufficientWordBankException {
		VerbQuizerService quizer = new VerbQuizerService();
		quizer.setDatabase(db);
		MultipleChoiceQuestion[] question = quizer.generateQuestions(10, new int[0]);
		Assert.assertEquals(10, question.length);
		for (MultipleChoiceQuestion m : question) {
			System.out.println(m.getQuestion());
			String[] questionWords = m.getQuestion().split(" ");
			String[] verbWords = questionWords[3].split(",");
			LatinVerb verb = new LatinVerb(1, verbWords[0], verbWords[1], verbWords[2], verbWords[3]);
			String tenseString = new String();
			for (int i = 7; i < questionWords.length; ++i) {
				tenseString = tenseString + " " + questionWords[i];
			}
			Tense t;
			tenseString = tenseString.trim();
			System.out.println(tenseString);
			switch (tenseString) {
			case "present active": {
				t = Tense.PRESENT;
				break;
			}
			case "present passive": {
				t = Tense.PRESENT_PASSIVE;
				break;
			}
			case "imperfect active": {
				t = Tense.IMPERFECT;
				break;
			}
			case "imperfect passive": {
				t = Tense.IMPERFECT_PASSIVE;
				break;
			}
			case "future active": {
				t = Tense.FUTURE;
				break;
			}
			case "future passive": {
				t = Tense.FUTURE_PASSIVE;
				break;
			}
			case "perfect active": {
				t = Tense.PERFECT;
				break;
			}
			case "pluperfect active": {
				t = Tense.PLUPERFECT;
				break;
			}
			case "future-perfect active": {
				t = Tense.FUTURE_PERFECT;
				break;
			}
			default: {
				throw new IllegalArgumentException();
			}
			}
			String[][] possibleConjugation = verb.conjugate(t);
			int row;
			switch (questionWords[5]) {
			case "first": {
				row = 0;
				break;
			}
			case "second": {
				row = 1;
				break;
			}
			case "third": {
				row = 2;
				break;
			}
			default: {
				throw new IllegalArgumentException();
			}
			}
			int column;
			switch (questionWords[6]) {
			case "singular": {
				column = 0;
				break;
			}
			case "plural": {
				column = 1;
				break;
			}
			default: {
				throw new IllegalArgumentException();
			}
			}
			String expectedAnswer = possibleConjugation[row][column];
			Assert.assertEquals(4, m.getChoices().size());
			Assert.assertEquals(expectedAnswer, m.getAnswer());
		}
	}
}
