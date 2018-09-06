package net.viperfish.latinQuiz.inflector;

import java.util.Arrays;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class ReplaceStemRule implements VerbRule {

	private static final String REPLACE_STEM = "verb.replaceStem";
	private String toReplace;
	private String replacement;
	private VerbRule rule;

	public ReplaceStemRule(String toReplace, String replacement, VerbRule rule) {
		this.toReplace = toReplace;
		this.replacement = replacement;
		this.rule = rule;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		StringBuilder sb = new StringBuilder(stem.getConjugated());
		int begin = sb.lastIndexOf(toReplace);
		if (begin != -1) {
			sb.replace(begin, begin + toReplace.length(), replacement);
		}
		stem.setConjugated(sb.toString());
		stem.getInterProduct().add(new MutableTriple<String, List<String>, String>(REPLACE_STEM,
				Arrays.asList(toReplace, replacement), sb.toString()));
		return rule.inflect(first, stem);
	}

}
