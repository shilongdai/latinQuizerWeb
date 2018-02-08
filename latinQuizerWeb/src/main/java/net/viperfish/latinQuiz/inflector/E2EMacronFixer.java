package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public class E2EMacronFixer extends FixerRule {

	public E2EMacronFixer(VerbRule c) {
		super(c, 1, 0);
	}

	@Override
	protected void fix(StringBuilder v) {
		int index = v.lastIndexOf("e");
		if (index != -1) {
			v.setCharAt(index, 'ē');
		}
	}

}
