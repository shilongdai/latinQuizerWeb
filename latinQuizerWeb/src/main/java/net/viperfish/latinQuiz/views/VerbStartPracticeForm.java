package net.viperfish.latinQuiz.views;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import net.viperfish.latinQuiz.core.Mood;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbType;
import net.viperfish.latinQuiz.core.Voice;

public class VerbStartPracticeForm {

	@Range(min = 1, max = 100, message = "{verbForm.inappAmount}")
	private int amount;
	@NotEmpty(message = "{verbForm.emptyConj}")
	private List<Integer> conjugations;
	@NotEmpty(message = "{verbForm.emptyTense}")
	private List<Tense> tenses;
	@NotEmpty(message = "{verbForm.emptyMood}")
	private List<Mood> moods;
	@NotEmpty(message = "{verbForm.emptyVoice}")
	private List<Voice> voices;
	@NotEmpty(message = "{verbForm.emptyTypes}")
	private List<VerbType> types;

	public VerbStartPracticeForm() {
		amount = 10;
		conjugations = new LinkedList<>();
		tenses = new LinkedList<>();
		moods = new LinkedList<>();
		voices = new LinkedList<>();
		types = new LinkedList<>();
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

	public List<Mood> getMoods() {
		return moods;
	}

	public void setMoods(List<Mood> moods) {
		this.moods = moods;
	}

	public List<Voice> getVoices() {
		return voices;
	}

	public void setVoices(List<Voice> voices) {
		this.voices = voices;
	}

	public List<VerbType> getTypes() {
		return types;
	}

	public void setTypes(List<VerbType> types) {
		this.types = types;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((conjugations == null) ? 0 : conjugations.hashCode());
		result = prime * result + ((moods == null) ? 0 : moods.hashCode());
		result = prime * result + ((tenses == null) ? 0 : tenses.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		result = prime * result + ((voices == null) ? 0 : voices.hashCode());
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
		if (moods == null) {
			if (other.moods != null)
				return false;
		} else if (!moods.equals(other.moods))
			return false;
		if (tenses == null) {
			if (other.tenses != null)
				return false;
		} else if (!tenses.equals(other.tenses))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		if (voices == null) {
			if (other.voices != null)
				return false;
		} else if (!voices.equals(other.voices))
			return false;
		return true;
	}

}
