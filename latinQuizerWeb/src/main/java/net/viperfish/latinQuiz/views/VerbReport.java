package net.viperfish.latinQuiz.views;

public class VerbReport {

	private int total;
	private int correct;
	private int incorrect;
	private int score;
	private String time;

	public VerbReport(int total, int correct, int incorrect, int score, String time) {
		super();
		this.total = total;
		this.correct = correct;
		this.incorrect = incorrect;
		this.score = score;
		this.time = time;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + correct;
		result = prime * result + incorrect;
		result = prime * result + score;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + total;
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
		VerbReport other = (VerbReport) obj;
		if (correct != other.correct) {
			return false;
		}
		if (incorrect != other.incorrect) {
			return false;
		}
		if (score != other.score) {
			return false;
		}
		if (time == null) {
			if (other.time != null) {
				return false;
			}
		} else if (!time.equals(other.time)) {
			return false;
		}
		return total == other.total;
	}

}
