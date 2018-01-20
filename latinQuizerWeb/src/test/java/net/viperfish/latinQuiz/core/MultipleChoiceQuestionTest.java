package net.viperfish.latinQuiz.core;

import org.junit.Assert;
import org.junit.Test;

public class MultipleChoiceQuestionTest {
	@Test
	public void testMultipleChoiceQuestion() {
		MultipleChoiceQuestion q = new MultipleChoiceQuestion("What is 1+1?");
		q.addChoice("1", false);
		q.addChoice("2", true);
		q.addChoice("3", false);
		Assert.assertEquals(new SingleTextualAnswer("2"), q.getAnswer());
		Assert.assertEquals("What is 1+1?", q.getQuestion());
	}
}
