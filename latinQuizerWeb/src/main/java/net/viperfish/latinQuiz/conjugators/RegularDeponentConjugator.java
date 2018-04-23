package net.viperfish.latinQuiz.conjugators;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.MutableTriple;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.ConjugationMapper;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.inflector.SpecialI18NCodes;

abstract class RegularDeponentConjugator extends RegularActiveConjugator {

	private int conj;

	public RegularDeponentConjugator(int conj) {
		this.conj = conj;
	}

	@Override
	public ConjugatedVerb[][] conjugate(Tense t, String first, String second, String third, String fourth) {
		second = convertToActInfinitive(second);
		ConjugatedVerb[][] results = super.conjugate(t, first, second, third, fourth);
		for (ConjugatedVerb[] a : results) {
			for (ConjugatedVerb i : a) {
				LinkedList<MutableTriple<String, List<String>, String>> interProduct = new LinkedList<>(
						i.getInterProduct());
				interProduct.addFirst(new MutableTriple<String, List<String>, String>(
						SpecialI18NCodes.DEPONENT_TO_PRESENT_PASSIVE_INF, new LinkedList<String>(), second));
			}
		}
		return results;
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
