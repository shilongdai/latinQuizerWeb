package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

public class PassivePresentFixer implements VerbRule {

	private VerbRule conj;
	private static final String PASSIVE_PRESENT_FIXER = "verb.passivePresentFixer";

	public PassivePresentFixer(VerbRule c) {
		this.conj = c;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {

		ConjugatedVerb[][] result = conj.inflect(first, stem);
		result[0][0].setConjugated(first + "r");
		result[0][0].getInterProduct().clear();
		result[0][0].getInterProduct().add(new MutableTriple<String, List<String>, String>(PASSIVE_PRESENT_FIXER,
				new LinkedList<String>(), result[0][0].getConjugated()));
		return result;
	}

}
