package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class IO2IAMFixer extends FixerRule {

	public IO2IAMFixer(VerbRule c) {
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
