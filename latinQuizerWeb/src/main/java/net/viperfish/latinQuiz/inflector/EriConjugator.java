package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class EriConjugator implements VerbRule {

	private static final String ERI_CONJ = "verb.conjugateEri";

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result = {{new ConjugatedVerb("ero"), new ConjugatedVerb("erimus")},
				{new ConjugatedVerb("eris"), new ConjugatedVerb("eritis")},
				{new ConjugatedVerb("erit"), new ConjugatedVerb("erint")}};
		for (ConjugatedVerb[] a : result) {
			for (ConjugatedVerb i : a) {
				i.getInterProduct().add(new MutableTriple<String, List<String>, String>(ERI_CONJ,
						new LinkedList<String>(), i.getConjugated()));
			}
		}
		return result;
	}

}
