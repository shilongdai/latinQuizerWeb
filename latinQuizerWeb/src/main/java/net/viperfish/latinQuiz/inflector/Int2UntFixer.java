package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;

public class Int2UntFixer extends FixerConjugator {

	public Int2UntFixer(Conjugator src) {
		super(src, 2, 1);
	}

	@Override
	protected void fix(StringBuilder sb) {
		int begin = sb.lastIndexOf("int");
		if (begin != -1) {
			sb.replace(begin, begin + 3, "unt");
		}
	}

}
