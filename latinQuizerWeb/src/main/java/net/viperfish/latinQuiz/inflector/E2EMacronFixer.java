package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class E2EMacronFixer extends ReplaceLastRule {

	public E2EMacronFixer(VerbRule c) {
		super(c, 1, 0, "e", "ē");
	}

}
