package net.viperfish.latinQuiz.core;

import java.util.HashSet;
import java.util.Set;

public final class MultipleChoiceQuestion extends Question {

	private String question;
	private Set<String> choices;

	public MultipleChoiceQuestion(String question) {
		this.question = question;
		choices = new HashSet<>();
	}

	public void addChoice(String possibleAnswer, boolean isCorrect) {
		choices.add(possibleAnswer);
		if (isCorrect) {
			this.setAnswer(new SingleTextualAnswer(possibleAnswer));
		}
	}

	public String getQuestion() {
		return question;
	}

	public HashSet<String> getChoices() {
		return new HashSet<>(choices);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((choices == null) ? 0 : choices.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultipleChoiceQuestion other = (MultipleChoiceQuestion) obj;
		if (choices == null) {
			if (other.choices != null)
				return false;
		} else if (!choices.equals(other.choices))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

}
