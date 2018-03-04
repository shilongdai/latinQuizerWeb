package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class IO2IAMFixer extends ReplaceLastRule {

	public IO2IAMFixer(VerbRule c) {
		super(c, 0, 0, "io", "iam");
	}

}
