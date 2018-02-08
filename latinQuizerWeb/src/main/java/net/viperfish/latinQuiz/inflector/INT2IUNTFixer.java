package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public final class INT2IUNTFixer extends FixerRule {

	public INT2IUNTFixer(VerbRule c) {
		super(c, 2, 1);
	}

	@Override
	protected void fix(StringBuilder v) {
		int begin = v.lastIndexOf("int");
		if (begin != -1) {
			v.replace(begin, begin + 3, "iunt");
		}
	}

}
