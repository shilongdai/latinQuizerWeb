package net.viperfish.latinQuiz.core;

import java.util.HashMap;
import java.util.Map;

public final class SynopsisAnswer implements Answer {

	private Map<Tense, String> rows;

	public SynopsisAnswer() {
		rows = new HashMap<>();
	}

	public Map<Tense, String> getRows() {
		return rows;
	}

	public void setRows(Map<Tense, String> rows) {
		this.rows = rows;
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
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SynopsisAnswer other = (SynopsisAnswer) obj;
		if (rows == null) {
			return other.rows == null;
		} else {
			return rows.equals(other.rows);
		}
	}

}
