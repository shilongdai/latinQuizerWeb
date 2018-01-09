package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;

// TODO: Optimize
public class IO2OFixer extends FixerConjugator {

	public IO2OFixer(Conjugator c) {
		super(c, 0, 0);
	}

	@Override
	protected void fix(StringBuilder sb) {
		int begin = sb.lastIndexOf("io");
		if (begin == -1) {
			return;
		}
		sb.replace(begin, begin + 2, "o");
	}

}
