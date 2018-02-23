package net.viperfish.latinQuiz.conjugators;

import net.viperfish.latinQuiz.core.ConjugationMapper;
import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.inflector.BaRule;
import net.viperfish.latinQuiz.inflector.CombiningRules;
import net.viperfish.latinQuiz.inflector.ER2ARFixer;
import net.viperfish.latinQuiz.inflector.ERule;
import net.viperfish.latinQuiz.inflector.EraConjugator;
import net.viperfish.latinQuiz.inflector.EriConjugator;
import net.viperfish.latinQuiz.inflector.INT2IUNTFixer;
import net.viperfish.latinQuiz.inflector.Int2UntFixer;
import net.viperfish.latinQuiz.inflector.NullRule;
import net.viperfish.latinQuiz.inflector.PassivePresentFixer;
import net.viperfish.latinQuiz.inflector.PresentStrapStemRule;
import net.viperfish.latinQuiz.inflector.StemPlusPassiveRule;
import net.viperfish.latinQuiz.inflector.SumRule;
import net.viperfish.latinQuiz.inflector.UM2IFixer;

public final class FourthDeponentConjugator extends RegularDeponentConjugator {

	public FourthDeponentConjugator() {
		super(ConjugationMapper.FOURTH_CONJ);
	}

	@Override
	protected void init() {
		addRule(Tense.PRESENT,
				new PresentStrapStemRule(new PassivePresentFixer(new INT2IUNTFixer(new StemPlusPassiveRule()))));
		addRule(Tense.IMPERFECT, new PresentStrapStemRule(new ERule(new BaRule(new StemPlusPassiveRule()))));
		addRule(Tense.FUTURE, new PresentStrapStemRule(new ER2ARFixer(new ERule(new StemPlusPassiveRule()))));
		addRule(Tense.PERFECT, new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new SumRule()));
		addRule(Tense.PLUPERFECT, new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new EraConjugator()));
		addRule(Tense.FUTURE_PERFECT,
				new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new Int2UntFixer(new EriConjugator())));
	}

}
