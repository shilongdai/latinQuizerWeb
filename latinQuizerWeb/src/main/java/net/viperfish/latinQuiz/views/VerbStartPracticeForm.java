package net.viperfish.latinQuiz.views;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import net.viperfish.latinQuiz.core.Tense;

public class VerbStartPracticeForm {

	@Range(min = 1, max = 100, message = "{verbForm.inappAmount}")
	private int amount;
	@NotEmpty(message = "{verbForm.emptyConj}")
	private List<Integer> conjugations;
	@NotEmpty(message = "{verbForm.emptyTense}")
	private List<Tense> tenses;

	public VerbStartPracticeForm() {
		amount = 10;
		conjugations = new LinkedList<>();
		tenses = new LinkedList<>();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public List<Integer> getConjugations() {
		return conjugations;
	}

	public void setConjugations(List<Integer> conjugations) {
		this.conjugations = conjugations;
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
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((conjugations == null) ? 0 : conjugations.hashCode());
		result = prime * result + ((tenses == null) ? 0 : tenses.hashCode());
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
		VerbStartPracticeForm other = (VerbStartPracticeForm) obj;
		if (amount != other.amount)
			return false;
		if (conjugations == null) {
			if (other.conjugations != null)
				return false;
		} else if (!conjugations.equals(other.conjugations))
			return false;
		if (tenses == null) {
			if (other.tenses != null)
				return false;
		} else if (!tenses.equals(other.tenses))
			return false;
		return true;
	}

}
