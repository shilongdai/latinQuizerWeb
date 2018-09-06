package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class PassiveBerisFixer implements VerbRule {

	private static final String PASSIVE_BERIS_FIXER = "verb.passiveBerisFixer";
	private VerbRule conj;

	public PassiveBerisFixer(VerbRule c) {
		this.conj = c;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result = conj.inflect(first, stem);
		StringBuilder sb = new StringBuilder(result[1][0].getConjugated());
		int begin = sb.lastIndexOf("biris");
		if (begin != -1) {
			sb.replace(begin, sb.length(), "beris");
		}
		result[1][0].setConjugated(sb.toString());
		result[1][0].getInterProduct()
				.add(new MutableTriple<String, List<String>, String>(PASSIVE_BERIS_FIXER,
						new LinkedList<String>(), sb.toString()));
		return result;
	}

}
