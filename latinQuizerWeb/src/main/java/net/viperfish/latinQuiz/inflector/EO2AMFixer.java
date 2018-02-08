package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class EO2AMFixer extends FixerRule {

	public EO2AMFixer(VerbRule c) {
		super(c, 0, 0);
	}

	@Override
	protected void fix(StringBuilder sb) {
		int begin = sb.lastIndexOf("eo");
		if (begin == -1) {
			return;
		}
		sb.replace(begin, begin + 2, "am");
	}
}
