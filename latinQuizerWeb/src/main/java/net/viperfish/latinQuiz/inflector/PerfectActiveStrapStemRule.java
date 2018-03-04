package net.viperfish.latinQuiz.inflector;

import net.viperfish.latinQuiz.core.VerbRule;

public final class PerfectActiveStrapStemRule implements VerbRule {

	private VerbRule src;

	public PerfectActiveStrapStemRule(VerbRule src) {
		this.src = src;
	}

	@Override
	public String[][] inflect(String first, String stem) {
		String toConjugate = stem;
		if (stem.charAt(stem.length() - 1) == 'i') {
			toConjugate = stem.substring(0, stem.length() - 1);
		}
		return src.inflect(first, toConjugate);
	}

}
