package net.viperfish.latinQuiz.inflector;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;
import org.apache.commons.lang3.tuple.MutableTriple;

public class StemPlusPerfectActiveEndingsRule implements VerbRule {

	private static final String STEM_PERFECT_ACTIVE_ENDINGS = "verb.stemPlusPerfectActiveEndings";

	public StemPlusPerfectActiveEndingsRule() {
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		String[][] endings = {{"i", "imus"}, {"isti", "istis"}, {"it", "erunt"}};
		String[][] result = new String[endings.length][];
		for (int i = 0; i < result.length; ++i) {
			result[i] = new String[endings[i].length];
		}
		for (int i = 0; i < endings.length; ++i) {
			for (int j = 0; j < endings[i].length; ++j) {
				result[i][j] = stem.getConjugated() + endings[i][j];
			}
		}
		ConjugatedVerb[][] returned = new ConjugatedVerb[result.length][result[0].length];
		for (int i = 0; i < endings.length; ++i) {
			for (int j = 0; j < endings[i].length; ++j) {
				returned[i][j] = new ConjugatedVerb(result[i][j]);
				returned[i][j].setInterProduct(new LinkedList<>(stem.getInterProduct()));
				returned[i][j].getInterProduct().add(new MutableTriple<String, List<String>, String>(
						STEM_PERFECT_ACTIVE_ENDINGS, Arrays.asList(endings[i][j]), result[i][j]));
			}
		}
		return returned;
	}

}
