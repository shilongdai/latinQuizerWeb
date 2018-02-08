package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class AO2AmFixer extends FixerRule {

	public AO2AmFixer(VerbRule c) {
		super(c, 0, 0);
	}

	@Override
	protected void fix(StringBuilder sb) {
		int begin = sb.lastIndexOf("ao");
		if (begin == -1) {
			return;
		}
		sb.replace(begin, begin + 2, "am");
	}

}
