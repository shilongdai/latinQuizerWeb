package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class Int2UntFixer extends ReplaceLastRule {

	public Int2UntFixer(VerbRule src) {
		super(src, 2, 1, "int", "unt");
	}

}
