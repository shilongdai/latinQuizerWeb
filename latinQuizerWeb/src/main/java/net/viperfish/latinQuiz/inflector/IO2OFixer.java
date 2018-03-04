package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

// TODO: Optimize
public class IO2OFixer extends ReplaceLastRule {

	public IO2OFixer(VerbRule c) {
		super(c, 0, 0, "io", "o");
	}

}
