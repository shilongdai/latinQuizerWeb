package net.viperfish.latinQuiz.conjugators;

import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.inflector.AppendRule;
import net.viperfish.latinQuiz.inflector.CombiningRules;
import net.viperfish.latinQuiz.inflector.EraConjugator;
import net.viperfish.latinQuiz.inflector.EriConjugator;
import net.viperfish.latinQuiz.inflector.IR2ORFixer;
import net.viperfish.latinQuiz.inflector.Int2UntFixer;
import net.viperfish.latinQuiz.inflector.NullRule;
import net.viperfish.latinQuiz.inflector.PassiveBerisFixer;
import net.viperfish.latinQuiz.inflector.PassivePresentFixer;
import net.viperfish.latinQuiz.inflector.PresentStrapStemRule;
import net.viperfish.latinQuiz.inflector.StemPlusPassiveRule;
import net.viperfish.latinQuiz.inflector.SumRule;
import net.viperfish.latinQuiz.inflector.UM2IFixer;

public final class FirstSecondIndicPassiveConjugator extends RegularPassiveConjugator {

	@Override
	protected void init() {
		addRule(Tense.PRESENT, new PresentStrapStemRule(new PassivePresentFixer(new StemPlusPassiveRule())));
		addRule(Tense.IMPERFECT, new PresentStrapStemRule(new AppendRule("ba", new StemPlusPassiveRule())));
		addRule(Tense.FUTURE, new PresentStrapStemRule(new Int2UntFixer(
				new PassiveBerisFixer(new IR2ORFixer(new AppendRule("bi", new StemPlusPassiveRule()))))));
		addRule(Tense.PERFECT, new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new SumRule()));
		addRule(Tense.PLUPERFECT, new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new EraConjugator()));
		addRule(Tense.FUTURE_PERFECT,
				new CombiningRules(new UM2IFixer(new NullRule(3, 2)), " ", new Int2UntFixer(new EriConjugator())));
	}

}
