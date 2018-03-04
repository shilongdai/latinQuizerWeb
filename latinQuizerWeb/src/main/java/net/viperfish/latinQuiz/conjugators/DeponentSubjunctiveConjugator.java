package net.viperfish.latinQuiz.conjugators;

import net.viperfish.latinQuiz.core.ConjugationMapper;
import net.viperfish.latinQuiz.core.Tense;

public class DeponentSubjunctiveConjugator extends SubjunctivePassiveConjugator {

	private int conj;

	public DeponentSubjunctiveConjugator(int conj) {
		super(conj);
		this.conj = conj;
	}

	@Override
	public String[][] conjugate(Tense t, String first, String second, String third, String fourth) {
		second = convertToActInfinitive(second);
		return super.conjugate(t, first, second, fourth, third);
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
