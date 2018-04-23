package net.viperfish.latinQuiz.conjugators;

import net.viperfish.latinQuiz.core.ConjugatedVerb;
import net.viperfish.latinQuiz.core.ConjugationMapper;
import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.core.VerbRule;
import net.viperfish.latinQuiz.inflector.CombiningRules;
import net.viperfish.latinQuiz.inflector.EssemRule;
import net.viperfish.latinQuiz.inflector.NullRule;
import net.viperfish.latinQuiz.inflector.PresentStrapStemRule;
import net.viperfish.latinQuiz.inflector.ReplaceStemRule;
import net.viperfish.latinQuiz.inflector.SimRule;
import net.viperfish.latinQuiz.inflector.StemPlusPassiveRule;
import net.viperfish.latinQuiz.inflector.UM2IFixer;

public class SubjunctivePassiveConjugator implements Conjugator {

	private VerbRule present;
	private VerbRule imperfect;
	private VerbRule perfect;
	private VerbRule pluperfect;

	public SubjunctivePassiveConjugator(int conj) {
		present = presentRule(conj);
		imperfect = new StemPlusPassiveRule();
		perfect = new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new SimRule());
		pluperfect = new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new EssemRule());
	}

	@Override
	public ConjugatedVerb[][] conjugate(Tense t, String first, String second, String third, String fourth) {
		ConjugatedVerb[][] result = new ConjugatedVerb[0][0];
		switch (t) {
		case PRESENT: {
			return present.inflect(first, new ConjugatedVerb(second));
		}
		case IMPERFECT: {
			return imperfect.inflect(first, new ConjugatedVerb(second));
		}
		case PERFECT: {
			return perfect.inflect(first, new ConjugatedVerb(fourth));
		}
		case PLUPERFECT:
			return pluperfect.inflect(first, new ConjugatedVerb(fourth));
		default:
			break;
		}
		return result;
	}

	private VerbRule presentRule(int conj) {
		switch (conj) {
		case ConjugationMapper.FIRST_CONJ: {
			return new PresentStrapStemRule(new ReplaceStemRule("a", "e", new StemPlusPassiveRule()));
		}
		case ConjugationMapper.SECOND_CONJ: {
			return new PresentStrapStemRule(new ReplaceStemRule("e", "ea", new StemPlusPassiveRule()));
		}
		case ConjugationMapper.THIRD_CONJ_O: {
			return new PresentStrapStemRule(new ReplaceStemRule("e", "a", new StemPlusPassiveRule()));
		}
		case ConjugationMapper.THIRD_CONJ_IO: {
			return new PresentStrapStemRule(new ReplaceStemRule("e", "ia", new StemPlusPassiveRule()));
		}
		case ConjugationMapper.FOURTH_CONJ: {
			return new PresentStrapStemRule(new ReplaceStemRule("i", "ia", new StemPlusPassiveRule()));
		}
		default: {
			return null;
		}
		}
	}

}
