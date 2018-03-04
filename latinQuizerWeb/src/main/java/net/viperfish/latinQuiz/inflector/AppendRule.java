package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbRule;

public class AppendRule implements VerbRule {

	private VerbRule rule;
	private String app;

	public AppendRule(String app, VerbRule rule) {
		this.rule = rule;
		this.app = app;
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		stem += app;
		return rule.inflect(first, stem, t);
	}

}
