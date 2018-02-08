package net.viperfish.latinQuiz.core;

public interface VerbRule {
	public String[][] inflect(String first, String stem, Tense t);
}
