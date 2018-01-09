package net.viperfish.latinQuiz.core;

public interface Conjugator {
	public String[][] inflect(String first, String stem, Tense t);
}
