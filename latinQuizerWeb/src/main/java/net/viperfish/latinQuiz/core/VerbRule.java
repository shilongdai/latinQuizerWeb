package net.viperfish.latinQuiz.core;

public interface VerbRule {
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb inProgress);
}
