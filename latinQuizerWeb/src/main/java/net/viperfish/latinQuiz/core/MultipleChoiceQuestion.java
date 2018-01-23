package net.viperfish.latinQuiz.core;

import java.util.HashSet;
import java.util.Set;

public final class MultipleChoiceQuestion extends Question {

	private Set<String> choices;

	public MultipleChoiceQuestion(String question) {
		super(null, question);
		choices = new HashSet<>();
	}

	public void addChoice(String possibleAnswer, boolean isCorrect) {
		choices.add(possibleAnswer);
		if (isCorrect) {
			this.setAnswer(new SingleTextualAnswer(possibleAnswer));
		}
	}

	public HashSet<String> getChoices() {
		return new HashSet<>(choices);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((choices == null) ? 0 : choices.hashCode());
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
		return true;
	}

}
