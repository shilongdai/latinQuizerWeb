package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

// TODO: Optimize
public class IO2OFixer extends FixerRule {

	public IO2OFixer(VerbRule c) {
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
