package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class EraConjugator implements VerbRule {

	private static final String ERA_CONJ = "verb.conjugateEra";

	public EraConjugator() {
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result = {{new ConjugatedVerb("eram"), new ConjugatedVerb("eramus")},
				{new ConjugatedVerb("eras"), new ConjugatedVerb("eratis")},
				{new ConjugatedVerb("erat"), new ConjugatedVerb("erant")}};
		for (ConjugatedVerb[] a : result) {
			for (ConjugatedVerb i : a) {
				i.getInterProduct().add(new MutableTriple<String, List<String>, String>(ERA_CONJ,
						new LinkedList<String>(), i.getConjugated()));
			}
		}
		return result;
	}

}
