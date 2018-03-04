package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class EO2AMFixer extends ReplaceLastRule {

	public EO2AMFixer(VerbRule c) {
		super(c, 0, 0, "eo", "am");
	}

}
