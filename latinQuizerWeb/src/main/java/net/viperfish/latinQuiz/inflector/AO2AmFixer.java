package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class AO2AmFixer extends ReplaceLastRule {

	public AO2AmFixer(VerbRule c) {
		super(c, 0, 0, "ao", "am");
	}

}
