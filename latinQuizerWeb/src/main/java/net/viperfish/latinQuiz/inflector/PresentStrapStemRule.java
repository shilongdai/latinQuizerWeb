package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

public final class PresentStrapStemRule implements VerbRule {

	private VerbRule verbRule;
	private static final String PRESENT_STRAP_STEM = "verb.presentStrapStem";

	public PresentStrapStemRule(VerbRule src) {
		this.verbRule = src;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		String toInflect = stem.getConjugated();
		if (toInflect.substring(toInflect.length() - 2, toInflect.length()).equalsIgnoreCase("re")) {
			toInflect = toInflect.substring(0, toInflect.length() - 2);
		}

		stem.setConjugated(toInflect);
		stem.getInterProduct().add(new MutableTriple<String, List<String>, String>(PRESENT_STRAP_STEM,
				new LinkedList<String>(), stem.getConjugated()));

		ConjugatedVerb[][] result = verbRule.inflect(first, stem);
		return result;
	}

}
