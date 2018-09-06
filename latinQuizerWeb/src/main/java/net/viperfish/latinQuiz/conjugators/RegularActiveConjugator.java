package net.viperfish.latinQuiz.conjugators;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

abstract class RegularActiveConjugator implements Conjugator {

	private Map<Tense, VerbRule> rules;

	public RegularActiveConjugator() {
		rules = new HashMap<>();
		init();
	}

	protected void addRule(Tense t, VerbRule rule) {
		rules.put(t, rule);
	}

	protected abstract void init();

	@Override
	public ConjugatedVerb[][] conjugate(Tense t, String first, String second, String third,
			String fourth) {
		VerbRule r = rules.get(t);
		if (r == null) {
			return new ConjugatedVerb[0][0];
		}
		ConjugatedVerb[][] result = new ConjugatedVerb[0][0];
		switch (t) {
			case PRESENT:
			case IMPERFECT:
			case FUTURE: {
				result = r.inflect(first, new ConjugatedVerb(second));
				break;
			}
			case PERFECT:
			case PLUPERFECT:
			case FUTURE_PERFECT: {
				result = r.inflect(first, new ConjugatedVerb(third));
				break;
			}
		}
		if (t == Tense.PRESENT) {
			result[0][0] = new ConjugatedVerb(first,
					Arrays.asList(new MutableTriple<String, List<String>, String>(
							SpecialI18NCodes.REGULAR_ACTIVE_PRESENT_FIRST_SING, new LinkedList<String>(),
							first)));
		}
		return result;
	}

}
