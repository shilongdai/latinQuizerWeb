package net.viperfish.latinQuiz.inflector;

import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class ConvertToIRule implements VerbRule {

	private static final String CONVERT_2_I_RULE = "verb.convert2i";

	private VerbRule src;

	public ConvertToIRule(VerbRule src) {
		this.src = src;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		StringBuilder sb = new StringBuilder(stem.getConjugated());
		int begin = sb.lastIndexOf("e");
		sb.setCharAt(begin, 'i');
		stem.setConjugated(sb.toString());
		stem.getInterProduct().add(new MutableTriple<String, List<String>, String>(CONVERT_2_I_RULE,
				new LinkedList<String>(), sb.toString()));
		return src.inflect(first, stem);
	}

}
