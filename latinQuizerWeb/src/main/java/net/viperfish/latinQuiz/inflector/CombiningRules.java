package net.viperfish.latinQuiz.inflector;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

public class CombiningRules implements VerbRule {

	private static final String COMBINE_RULE = "verb.combineRule";

	private VerbRule first;
	private VerbRule second;
	private String seperator;

	public CombiningRules(VerbRule first, String seperator, VerbRule second) {
		this.first = first;
		this.second = second;
		this.seperator = seperator;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result1 = this.first.inflect(first, stem);
		ConjugatedVerb[][] result2 = this.second.inflect(first, stem);
		ConjugatedVerb[][] finalResult = new ConjugatedVerb[result1.length][result1[0].length];
		for (int i = 0; i < result1.length; ++i) {
			for (int j = 0; j < result1[i].length; ++j) {
				finalResult[i][j] = new ConjugatedVerb();
				finalResult[i][j]
						.setConjugated(result1[i][j].getConjugated() + seperator + result2[i][j].getConjugated());
				finalResult[i][j].getInterProduct().addAll(result1[i][j].getInterProduct());
				finalResult[i][j].getInterProduct().addAll(result2[i][j].getInterProduct());
				finalResult[i][j].getInterProduct()
						.add(new MutableTriple<String, List<String>, String>(COMBINE_RULE,
								Arrays.asList(result1[i][j].getConjugated(), result2[i][j].getConjugated()),
								finalResult[i][j].getConjugated()));
			}
		}
		return finalResult;
	}

}
