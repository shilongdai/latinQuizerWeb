package net.viperfish.latinQuiz.core;

public class SingleTextualAnswer implements Answer {

	private String answer;

	public SingleTextualAnswer() {
	}

	public SingleTextualAnswer(String answer) {
		super();
		this.answer = answer;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SingleTextualAnswer other = (SingleTextualAnswer) obj;
		if (answer == null) {
			return other.answer == null;
		} else {
			return answer.equals(other.answer);
		}
	}

}
