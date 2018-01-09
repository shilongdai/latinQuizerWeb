package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;

public class IR2ERFixer extends FixerConjugator {

	public IR2ERFixer(Conjugator c) {
		super(c, 1, 0);
	}

	@Override
	protected void fix(StringBuilder sb) {
		int begin = sb.lastIndexOf("ir");
		if (begin == -1) {
			return;
		}
		sb.replace(begin, begin + 2, "er");
	}

}
