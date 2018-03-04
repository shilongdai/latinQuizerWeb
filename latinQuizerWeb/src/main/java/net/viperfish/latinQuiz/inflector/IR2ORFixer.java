package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class IR2ORFixer extends ReplaceLastRule {

	public IR2ORFixer(VerbRule c) {
		super(c, 0, 0, "ir", "or");
	}

}
