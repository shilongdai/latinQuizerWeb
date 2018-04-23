package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

public final class PerfectActiveStrapStemRule implements VerbRule {

	private VerbRule src;
	private static final String STRAP_STEM_PERFECT_ACTIVE = "verb.strapStemPerfectActive";

	public PerfectActiveStrapStemRule(VerbRule src) {
		this.src = src;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		String toConjugate = stem.getConjugated();
		if (toConjugate.charAt(toConjugate.length() - 1) == 'i') {
			toConjugate = toConjugate.substring(0, toConjugate.length() - 1);
		}
		stem.setConjugated(toConjugate);
		stem.getInterProduct().add(new MutableTriple<String, List<String>, String>(STRAP_STEM_PERFECT_ACTIVE,
				new LinkedList<String>(), stem.getConjugated()));
		return src.inflect(first, stem);
	}

}
