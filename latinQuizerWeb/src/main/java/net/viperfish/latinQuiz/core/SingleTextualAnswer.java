package net.viperfish.latinQuiz.core;

import java.util.LinkedList;
import java.util.List;

import javax.lang.model.type.NullType;

import org.apache.commons.lang3.tuple.Triple;

public class SingleTextualAnswer implements Answer<NullType> {

	private String answer;
	private List<? extends Triple<String, ? extends List<String>, String>> steps;

	public SingleTextualAnswer() {
		steps = new LinkedList<Triple<String, List<String>, String>>();
	}

	public SingleTextualAnswer(String answer, List<? extends Triple<String, ? extends List<String>, String>> steps) {
		super();
		this.answer = answer;
		this.steps = steps;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public List<? extends Triple<String, ? extends List<String>, String>> getSteps() {
		return steps;
	}

	public void setSteps(List<? extends Triple<String, List<String>, String>> steps) {
		this.steps = steps;
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleTextualAnswer other = (SingleTextualAnswer) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		return true;
	}

	@Override
	public List<? extends Triple<String, ? extends List<String>, String>> getSteps(NullType key) {
		return steps;
	}

}
