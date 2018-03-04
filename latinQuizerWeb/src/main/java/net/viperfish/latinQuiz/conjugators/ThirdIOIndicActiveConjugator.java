package net.viperfish.latinQuiz.conjugators;

import net.viperfish.latinQuiz.core.Tense;
import net.viperfish.latinQuiz.inflector.AO2AmFixer;
import net.viperfish.latinQuiz.inflector.AppendRule;
import net.viperfish.latinQuiz.inflector.CombiningRules;
import net.viperfish.latinQuiz.inflector.ConvertToIRule;
import net.viperfish.latinQuiz.inflector.EO2AMFixer;
import net.viperfish.latinQuiz.inflector.EraConjugator;
import net.viperfish.latinQuiz.inflector.EriConjugator;
import net.viperfish.latinQuiz.inflector.INT2IUNTFixer;
import net.viperfish.latinQuiz.inflector.NullRule;
import net.viperfish.latinQuiz.inflector.PerfectActiveStrapStemRule;
import net.viperfish.latinQuiz.inflector.PresentStrapStemRule;
import net.viperfish.latinQuiz.inflector.StemPlusPerfectActiveEndingsRule;
import net.viperfish.latinQuiz.inflector.StemPlusPresentActiveEndingsRule;

public final class ThirdIOIndicActiveConjugator extends RegularActiveConjugator {

	@Override
	protected void init() {
		addRule(Tense.PRESENT, new PresentStrapStemRule(
				new INT2IUNTFixer(new ConvertToIRule(new StemPlusPresentActiveEndingsRule()))));
		addRule(Tense.IMPERFECT, new PresentStrapStemRule(
				new AO2AmFixer(new ConvertToIRule(new AppendRule("eba", new StemPlusPresentActiveEndingsRule())))));
		addRule(Tense.FUTURE, new PresentStrapStemRule(
				new EO2AMFixer(new ConvertToIRule(new AppendRule("e", new StemPlusPresentActiveEndingsRule())))));
		addRule(Tense.PERFECT, new PerfectActiveStrapStemRule(new StemPlusPerfectActiveEndingsRule()));
		addRule(Tense.PLUPERFECT,
				new CombiningRules(new PerfectActiveStrapStemRule(new NullRule(3, 2)), "", new EraConjugator()));
		addRule(Tense.FUTURE_PERFECT,
				new CombiningRules(new PerfectActiveStrapStemRule(new NullRule(3, 2)), "", new EriConjugator()));
	}

}
