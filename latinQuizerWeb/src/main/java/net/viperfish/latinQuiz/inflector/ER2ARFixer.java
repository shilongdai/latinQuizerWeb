package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;

public class ER2ARFixer extends FixerConjugator {

	public ER2ARFixer(Conjugator c) {
		super(c, 0, 0);
	}

	@Override
	protected void fix(StringBuilder v) {
		int begin = v.lastIndexOf("er");
		if (begin != -1) {
			v.replace(begin, begin + 2, "ar");
		}
	}

}
