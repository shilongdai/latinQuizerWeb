package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public final class EssemRule implements VerbRule {

	private static final String ESSEM_CONJ = "verb.conjugateEssem";

	public EssemRule() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] results = {{new ConjugatedVerb("essem"), new ConjugatedVerb("essemus")},
				{new ConjugatedVerb("esses"), new ConjugatedVerb("essetis")},
				{new ConjugatedVerb("esset"), new ConjugatedVerb("essent")}};
		for (ConjugatedVerb[] a : results) {
			for (ConjugatedVerb i : a) {
				i.getInterProduct().add(new MutableTriple<String, List<String>, String>(ESSEM_CONJ,
						new LinkedList<String>(), i.getConjugated()));
			}
		}
		return results;
	}

}
