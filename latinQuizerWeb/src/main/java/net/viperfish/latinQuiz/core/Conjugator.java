package net.viperfish.latinQuiz.core;

public interface Conjugator {
	public String[][] conjugate(Tense t, String first, String second, String third, String fourth);
}
