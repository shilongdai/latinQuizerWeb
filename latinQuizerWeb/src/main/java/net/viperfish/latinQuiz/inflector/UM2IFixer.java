package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

public class UM2IFixer implements VerbRule {

	private VerbRule conj;
	private static final String UM2IRule = "verb.replaceUm2I";

	public UM2IFixer(VerbRule conj) {
		super();
		this.conj = conj;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result = conj.inflect(first, stem);
		for (int i = 0; i < 3; ++i) {
			StringBuilder sb = new StringBuilder(result[i][1].getConjugated());
			int begin = sb.lastIndexOf("um");
			if (begin != -1) {
				sb.replace(begin, begin + 2, "i");
			}
			result[i][1].setConjugated(sb.toString());
			result[i][1].getInterProduct().add(
					new MutableTriple<String, List<String>, String>(UM2IRule, new LinkedList<String>(), sb.toString()));
		}
		return result;
	}

}
