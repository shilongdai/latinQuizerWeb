package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

public class SumRule implements VerbRule {

	private static final String ESSEM_CONJ = "verb.conjugateEssem";

	public SumRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] results = { { new ConjugatedVerb("sum"), new ConjugatedVerb("sumus") },
				{ new ConjugatedVerb("es"), new ConjugatedVerb("estis") },
				{ new ConjugatedVerb("est"), new ConjugatedVerb("sunt") } };
		for (ConjugatedVerb[] a : results) {
			for (ConjugatedVerb i : a) {
				i.getInterProduct().add(new MutableTriple<String, List<String>, String>(ESSEM_CONJ,
						new LinkedList<String>(), i.getConjugated()));
			}
		}
		return results;
	}

}
