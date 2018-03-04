package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class IR2ERFixer extends ReplaceLastRule {

	public IR2ERFixer(VerbRule c) {
		super(c, 1, 0, "ir", "er");
	}

}
