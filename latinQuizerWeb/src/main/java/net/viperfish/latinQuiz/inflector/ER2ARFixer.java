package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class ER2ARFixer extends ReplaceLastRule {

	public ER2ARFixer(VerbRule c) {
		super(c, 0, 0, "er", "ar");
	}

}
