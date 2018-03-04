package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class ReplaceStemRule implements VerbRule {

	private String toReplace;
	private String replacement;
	private VerbRule rule;

	public ReplaceStemRule(String toReplace, String replacement, VerbRule rule) {
		this.toReplace = toReplace;
		this.replacement = replacement;
		this.rule = rule;
	}

	@Override
	public String[][] inflect(String first, String stem) {
		StringBuilder sb = new StringBuilder(stem);
		int begin = sb.lastIndexOf(toReplace);
		if (begin != -1) {
			sb.replace(begin, begin + toReplace.length(), replacement);
		}
		return rule.inflect(first, sb.toString());
	}

}
