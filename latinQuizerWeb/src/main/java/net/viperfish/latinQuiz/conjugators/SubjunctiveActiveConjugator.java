package net.viperfish.latinQuiz.conjugators;

import net.viperfish.latinQuiz.core.ConjugationMapper;
import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.inflector.AppendRule;
import net.viperfish.latinQuiz.inflector.PerfectActiveStrapStemRule;
import net.viperfish.latinQuiz.inflector.PresentStrapStemRule;
import net.viperfish.latinQuiz.inflector.ReplaceStemRule;
import net.viperfish.latinQuiz.inflector.StemPlusPresentActiveMEnding;

public class SubjunctiveActiveConjugator implements Conjugator {

	private VerbRule present;
	private VerbRule imperfect;
	private VerbRule perfect;
	private VerbRule pluperfect;

	public SubjunctiveActiveConjugator(int conj) {
		present = presentRule(conj);
		imperfect = new StemPlusPresentActiveMEnding();
		perfect = new PerfectActiveStrapStemRule(new AppendRule("eri", new StemPlusPresentActiveMEnding()));
		pluperfect = new PerfectActiveStrapStemRule(new AppendRule("isse", new StemPlusPresentActiveMEnding()));
	}

	@Override
	public String[][] conjugate(Tense t, String first, String second, String third, String fourth) {
		String[][] result = new String[0][0];
		switch (t) {
		case PRESENT: {
			return present.inflect(first, second);
		}
		case IMPERFECT: {
			return imperfect.inflect(first, second);
		}
		case PERFECT: {
			return perfect.inflect(first, third);
		}
		case PLUPERFECT:
			return pluperfect.inflect(first, third);
		default:
			break;
		}
		return result;
	}

	private VerbRule presentRule(int conj) {
		switch (conj) {
		case ConjugationMapper.FIRST_CONJ: {
			return new PresentStrapStemRule(new ReplaceStemRule("a", "e", new StemPlusPresentActiveMEnding()));
		}
		case ConjugationMapper.SECOND_CONJ: {
			return new PresentStrapStemRule(new ReplaceStemRule("e", "ea", new StemPlusPresentActiveMEnding()));
		}
		case ConjugationMapper.THIRD_CONJ_O: {
			return new PresentStrapStemRule(new ReplaceStemRule("e", "a", new StemPlusPresentActiveMEnding()));
		}
		case ConjugationMapper.THIRD_CONJ_IO: {
			return new PresentStrapStemRule(new ReplaceStemRule("e", "ia", new StemPlusPresentActiveMEnding()));
		}
		case ConjugationMapper.FOURTH_CONJ: {
			return new PresentStrapStemRule(new ReplaceStemRule("i", "ia", new StemPlusPresentActiveMEnding()));
		}
		default: {
			return null;
		}
		}
	}

}
