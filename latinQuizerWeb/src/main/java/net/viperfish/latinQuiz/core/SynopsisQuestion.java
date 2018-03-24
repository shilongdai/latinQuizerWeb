package net.viperfish.latinQuiz.core;

import java.util.LinkedList;
import java.util.List;

public final class SynopsisQuestion extends Question {

	private List<Tense> tenses;

	public SynopsisQuestion() {
		super(null, null, QuestionType.SYNOPSIS);
		tenses = new LinkedList<>();
	}

	public List<Tense> getTenses() {
		return tenses;
	}

	public void setTenses(List<Tense> tenses) {
		this.tenses = tenses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tenses == null) ? 0 : tenses.hashCode());
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
		SynopsisQuestion other = (SynopsisQuestion) obj;
		if (tenses == null) {
			if (other.tenses != null)
				return false;
		} else if (!tenses.equals(other.tenses))
			return false;
		return true;
	}

}
