package net.viperfish.latinQuiz.inflector;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

abstract class ReplaceLastRule implements VerbRule {

	private static final String REPLACE_RULE_I18N = "verb.replaceRule";

	private VerbRule conj;
	private int row;
	private int column;
	private String toReplace;
	private String replacement;

	public ReplaceLastRule(VerbRule c, int row, int column, String toReplace, String replacement) {
		this.conj = c;
		this.row = row;
		this.column = column;
		this.toReplace = toReplace;
		this.replacement = replacement;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result = conj.inflect(first, stem);
		StringBuilder sb = new StringBuilder(result[row][column].getConjugated());

		int begin = sb.lastIndexOf(toReplace);
		if (begin != -1) {
			sb.replace(begin, begin + toReplace.length(), replacement);
		}

		result[row][column].setConjugated(sb.toString());
		result[row][column].getInterProduct().add(new MutableTriple<String, List<String>, String>(REPLACE_RULE_I18N,
				Arrays.asList(toReplace, replacement), sb.toString()));

		return result;
	}

}
