package net.viperfish.latinQuiz.views;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class VerbStartPracticeForm {

	@Range(min = 1, max = 100, message = "{verbForm.inappAmount}")
	private int amount;
	@NotEmpty(message = "{verbForm.emptyConj}")
	private List<Integer> conjugations;

	public VerbStartPracticeForm() {
		amount = 10;
		conjugations = new LinkedList<>();
	}

	public VerbStartPracticeForm(int amount, List<Integer> conjugations) {
		super();
		this.amount = amount;
		this.conjugations = conjugations;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((conjugations == null) ? 0 : conjugations.hashCode());
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
		return true;
	}

}
