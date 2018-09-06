package net.viperfish.latinQuiz.core;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.Triple;

public final class SynopsisQuestion extends Question {

	private List<Tense> tenses;
	private Map<Tense, List<? extends Triple<String, ? extends List<String>, String>>> steps;

	public SynopsisQuestion() {
		super(null, null, QuestionType.SYNOPSIS);
		tenses = new LinkedList<>();
		steps = new HashMap<>();
	}

	public List<Tense> getTenses() {
		return tenses;
	}

	public void setTenses(List<Tense> tenses) {
		this.tenses = tenses;
	}

	public Map<Tense, List<? extends Triple<String, ? extends List<String>, String>>> getSteps() {
		return steps;
	}

	public void setSteps(
			Map<Tense, List<? extends Triple<String, ? extends List<String>, String>>> steps) {
		this.steps = steps;
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
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SynopsisQuestion other = (SynopsisQuestion) obj;
		if (tenses == null) {
			return other.tenses == null;
		} else {
			return tenses.equals(other.tenses);
		}
	}

}
