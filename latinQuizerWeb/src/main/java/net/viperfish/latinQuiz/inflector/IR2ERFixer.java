package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class IR2ERFixer extends FixerRule {

	public IR2ERFixer(VerbRule c) {
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
