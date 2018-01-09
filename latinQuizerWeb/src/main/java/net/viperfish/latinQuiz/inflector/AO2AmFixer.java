package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.Conjugator;

public class AO2AmFixer extends FixerConjugator {

	public AO2AmFixer(Conjugator c) {
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
