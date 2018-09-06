package net.viperfish.latinQuiz.core;

public interface VerbRule {

	ConjugatedVerb[][] inflect(String first, ConjugatedVerb inProgress);
}
