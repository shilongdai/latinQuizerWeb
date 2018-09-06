package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class SimRule implements VerbRule {

	private static final String SIM_RULE = "verb.conjSim";

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result = {{new ConjugatedVerb("sim"), new ConjugatedVerb("simus")},
				{new ConjugatedVerb("sis"), new ConjugatedVerb("sitis")},
				{new ConjugatedVerb("sit"), new ConjugatedVerb("sint")}};
		for (ConjugatedVerb[] a : result) {
			for (ConjugatedVerb i : a) {
				i.getInterProduct().add(new MutableTriple<String, List<String>, String>(SIM_RULE,
						new LinkedList<String>(), i.getConjugated()));
			}
		}
		return result;
	}

}
