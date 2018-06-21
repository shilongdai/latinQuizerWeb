package net.viperfish.latinQuiz.views;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.validator.constraints.Range;

import net.viperfish.latinQuiz.core.Gender;
import net.viperfish.latinQuiz.core.NounType;

public class NounStartPracticeForm {

	private List<Gender> genders;
	private List<Integer> declensions;
	private List<NounType> types;
	@Range(min = 1, max = 100, message = "{verbForm.inappAmount}")
	private int amount;
	
	public NounStartPracticeForm() {
		genders = new LinkedList<>();
		declensions = new LinkedList<>();
		types = new LinkedList<>();
		amount = 10;
	}
	
	public NounStartPracticeForm(List<Gender> genders, List<Integer> declensions, List<NounType> types, int amount) {
		super();
		this.genders = genders;
		this.declensions = declensions;
		this.types = types;
		this.amount = amount;
	}
	public List<Gender> getGenders() {
		return genders;
	}
	public void setGenders(List<Gender> genders) {
		this.genders = genders;
	}
	public List<Integer> getDeclensions() {
		return declensions;
	}
	public void setDeclensions(List<Integer> declensions) {
		this.declensions = declensions;
	}
	public List<NounType> getTypes() {
		return types;
	}
	public void setTypes(List<NounType> types) {
		this.types = types;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((declensions == null) ? 0 : declensions.hashCode());
		result = prime * result + ((genders == null) ? 0 : genders.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
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
		NounStartPracticeForm other = (NounStartPracticeForm) obj;
		if (amount != other.amount)
			return false;
		if (declensions == null) {
			if (other.declensions != null)
				return false;
		} else if (!declensions.equals(other.declensions))
			return false;
		if (genders == null) {
			if (other.genders != null)
				return false;
		} else if (!genders.equals(other.genders))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}
	
	
	
}
