package net.viperfish.latinQuiz.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Triple;

public final class SynopsisAnswer implements Answer<Tense> {

	private Map<Tense, MutablePair<String, List<? extends Triple<String, ? extends List<String>, String>>>> rows;

	public SynopsisAnswer() {
		rows = new HashMap<>();
	}

	public Map<Tense, MutablePair<String, List<? extends Triple<String, ? extends List<String>, String>>>> getRows() {
		return rows;
	}

	public void setRows(
			Map<Tense, MutablePair<String, List<? extends Triple<String, ? extends List<String>, String>>>> rows) {
		this.rows = rows;
	}

	@Override
	public List<? extends Triple<String, ? extends List<String>, String>> getSteps() {
		return rows.get(Tense.PRESENT).getRight();
	}

	@Override
	public List<? extends Triple<String, ? extends List<String>, String>> getSteps(Tense key) {
		return rows.get(key).getRight();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rows == null) ? 0 : rows.hashCode());
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
		SynopsisAnswer other = (SynopsisAnswer) obj;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		return true;
	}

}
