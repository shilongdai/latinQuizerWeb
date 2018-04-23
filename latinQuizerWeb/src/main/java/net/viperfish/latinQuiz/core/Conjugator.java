package net.viperfish.latinQuiz.core;

public interface Conjugator {
	public ConjugatedVerb[][] conjugate(Tense t, String first, String second, String third, String fourth);
}
