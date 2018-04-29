package net.viperfish.latinQuiz.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.Triple;

public final class MultipleChoiceQuestion extends Question {

	private Set<String> choices;
	private List<? extends Triple<String, ? extends List<String>, String>> steps;

	public MultipleChoiceQuestion(String question) {
		super(null, question, QuestionType.MULTIPLE_CHOICE);
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

	public List<? extends Triple<String, ? extends List<String>, String>> getSteps() {
		return steps;
	}

	public void setSteps(List<? extends Triple<String, ? extends List<String>, String>> steps) {
		this.steps = steps;
	}

	public void setChoices(Set<String> choices) {
		this.choices = choices;
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
