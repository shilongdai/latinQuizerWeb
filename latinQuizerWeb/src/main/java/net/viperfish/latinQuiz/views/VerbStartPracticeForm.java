package net.viperfish.latinQuiz.views;

import org.hibernate.validator.constraints.Range;

public class VerbStartPracticeForm {

	@Range(min = 1, max = 100, message = "{verbForm.inappAmount}")
	private int amount;
	private boolean firstConj;

	public VerbStartPracticeForm() {
		amount = 10;
		firstConj = true;
	}

	public VerbStartPracticeForm(int amount, boolean firstConj) {
		super();
		this.amount = amount;
		this.firstConj = firstConj;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isFirstConj() {
		return firstConj;
	}

	public void setFirstConj(boolean firstConj) {
		this.firstConj = firstConj;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + (firstConj ? 1231 : 1237);
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
		if (firstConj != other.firstConj)
			return false;
		return true;
	}

}
