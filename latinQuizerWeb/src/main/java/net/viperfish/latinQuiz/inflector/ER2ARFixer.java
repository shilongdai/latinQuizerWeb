package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class ER2ARFixer extends FixerRule {

	public ER2ARFixer(VerbRule c) {
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
