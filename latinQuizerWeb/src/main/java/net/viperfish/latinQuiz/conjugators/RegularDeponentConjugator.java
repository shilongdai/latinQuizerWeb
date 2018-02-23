package net.viperfish.latinQuiz.conjugators;

import java.util.HashMap;
import java.util.Map;

import net.viperfish.latinQuiz.core.ConjugationMapper;
import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbRule;

abstract class RegularDeponentConjugator implements Conjugator {

	private Map<Tense, VerbRule> rules;
	private int conj;

	protected void addRule(Tense t, VerbRule rule) {
		rules.put(t, rule);
	}

	protected abstract void init();

	public RegularDeponentConjugator(int conj) {
		rules = new HashMap<>();
		this.conj = conj;
		init();
	}

	@Override
	public String[][] conjugate(Tense t, String first, String second, String third, String fourth) {
		VerbRule r = rules.get(t);
		if (r == null) {
			return new String[0][0];
		}
		second = convertToActInfinitive(second);
		String[][] result = new String[0][0];
		switch (t) {
		case PRESENT:
		case IMPERFECT:
		case FUTURE: {
			result = r.inflect(first, second, t);
			break;
		}
		case PERFECT:
		case PLUPERFECT:
		case FUTURE_PERFECT: {
			result = r.inflect(first, third, t);
			break;
		}
		}
		if (t == Tense.PRESENT) {
			result[0][0] = first;
		}
		return result;
	}

	private String convertToActInfinitive(String deponentInf) {
		switch (conj) {
		case ConjugationMapper.FIRST_CONJ:
		case ConjugationMapper.SECOND_CONJ:
		case ConjugationMapper.FOURTH_CONJ: {
			deponentInf = deponentInf.substring(0, deponentInf.length() - 1) + "e";
			break;
		}
		case ConjugationMapper.THIRD_CONJ_O:
		case ConjugationMapper.THIRD_CONJ_IO: {
			deponentInf = deponentInf.substring(0, deponentInf.length() - 1) + "ere";
		}
		}
		return deponentInf;
	}

}
