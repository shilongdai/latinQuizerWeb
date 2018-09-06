package net.viperfish.latinQuiz.inflector;

import java.util.Arrays;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class AppendRule implements VerbRule {

	private static final String VERB_APPENDRULE = "verb.appendRule";

	private VerbRule rule;
	private String app;

	public AppendRule(String app, VerbRule rule) {
		this.rule = rule;
		this.app = app;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		stem.setConjugated(stem.getConjugated() + app);
		stem.getInterProduct()
				.add(new MutableTriple<String, List<String>, String>(VERB_APPENDRULE, Arrays.asList(app),
						stem.getConjugated()));
		return rule.inflect(first, stem);
	}

}
