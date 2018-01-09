package net.viperfish.latinQuiz.core;

import java.util.HashSet;
import java.util.Set;

public final class MultipleChoiceQuestion {

	private String question;
	private String answer;
	private Set<String> choices;

	public MultipleChoiceQuestion(String question) {
		this.question = question;
		choices = new HashSet<>();
	}

	public void addChoice(String possibleAnswer, boolean isCorrect) {
		choices.add(possibleAnswer);
		if (isCorrect) {
			answer = possibleAnswer;
		}
	}

	public String getAnswer() {
		return answer;
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
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((choices == null) ? 0 : choices.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MultipleChoiceQuestion other = (MultipleChoiceQuestion) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
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
