package net.viperfish.latinQuiz.inflector;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.VerbRule;

public class NullRule implements VerbRule {

	private int row;
	private int column;

	private static final String NULLRULE = "verb.nullRule";

	public NullRule(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	@Override
	public ConjugatedVerb[][] inflect(String first, ConjugatedVerb stem) {
		ConjugatedVerb[][] result = new ConjugatedVerb[row][column];
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < column; ++j) {
				result[i][j] = new ConjugatedVerb(stem.getConjugated());
				result[i][j].getInterProduct().add(new MutableTriple<String, List<String>, String>(NULLRULE,
						Arrays.asList(result[i][j].getConjugated()), result[i][j].getConjugated()));
			}
		}
		return result;
	}

}
