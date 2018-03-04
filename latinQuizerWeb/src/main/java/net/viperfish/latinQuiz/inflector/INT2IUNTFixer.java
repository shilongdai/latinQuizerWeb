package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public final class INT2IUNTFixer extends ReplaceLastRule {

	public INT2IUNTFixer(VerbRule c) {
		super(c, 2, 1, "int", "iunt");
	}

}
