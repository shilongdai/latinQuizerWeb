package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;

public class IO2IAMFixer extends FixerConjugator {

	public IO2IAMFixer(Conjugator c) {
		super(c, 0, 0);
	}

	@Override
	protected void fix(StringBuilder v) {
		int begin = v.lastIndexOf("io");
		if (begin != -1) {
			v.replace(begin, begin + 2, "iam");
		}
	}

}
