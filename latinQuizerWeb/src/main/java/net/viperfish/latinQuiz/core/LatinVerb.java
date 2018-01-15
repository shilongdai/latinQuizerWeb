package net.viperfish.latinQuiz.core;

import java.io.Serializable;
import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import net.viperfish.latinQuiz.inflector.AO2AmFixer;
import net.viperfish.latinQuiz.inflector.BaConjugator;
import net.viperfish.latinQuiz.inflector.BiConjugator;
import net.viperfish.latinQuiz.inflector.CombiningConjugator;
import net.viperfish.latinQuiz.inflector.ConvertToIConjugator;
import net.viperfish.latinQuiz.inflector.E2EMacronFixer;
import net.viperfish.latinQuiz.inflector.EConjugator;
import net.viperfish.latinQuiz.inflector.EO2AMFixer;
import net.viperfish.latinQuiz.inflector.ER2ARFixer;
import net.viperfish.latinQuiz.inflector.EraConjugator;
import net.viperfish.latinQuiz.inflector.EriConjugator;
import net.viperfish.latinQuiz.inflector.INT2IUNTFixer;
import net.viperfish.latinQuiz.inflector.IO2OFixer;
import net.viperfish.latinQuiz.inflector.IR2ERFixer;
import net.viperfish.latinQuiz.inflector.IR2ORFixer;
import net.viperfish.latinQuiz.inflector.Int2UntFixer;
import net.viperfish.latinQuiz.inflector.NullConjugator;
import net.viperfish.latinQuiz.inflector.PassiveBerisFixer;
import net.viperfish.latinQuiz.inflector.PassivePresentFixer;
import net.viperfish.latinQuiz.inflector.PerfectActiveStrapStemConjugator;
import net.viperfish.latinQuiz.inflector.PresentStrapStemConjugator;
import net.viperfish.latinQuiz.inflector.StemPlusPassiveEndings;
import net.viperfish.latinQuiz.inflector.StemPlusPerfectActiveEndingsConjugator;
import net.viperfish.latinQuiz.inflector.StemPlusPresentActiveEndingsConjugator;
import net.viperfish.latinQuiz.inflector.SumConjugator;
import net.viperfish.latinQuiz.inflector.UM2IFixer;

@Entity
@Table(name = "Verbs")
public class LatinVerb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 586774505062107762L;
	private long id;
	@Range(min = 1, max = 4)
	private int conjugation;
	@NotBlank
	private String presentFirst;
	@NotBlank
	private String genitive;
	private String perfectFirst;
	private String passiveFirst;
	@Transient
	private Map<Tense, Conjugator> conjugatorMappings;
	@Transient
	private boolean initialized;

	private static final Pattern DIACRITICS_AND_FRIENDS = Pattern
			.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");

	public LatinVerb(int conjugation, String presentFirst, String genitive, String perfectFirst, String passiveFirst) {
		this();
		this.conjugation = conjugation;
		this.presentFirst = presentFirst;
		this.genitive = genitive;
		this.perfectFirst = perfectFirst;
		this.passiveFirst = passiveFirst;
	}

	public LatinVerb() {
		super();
		conjugatorMappings = new HashMap<>();
		initialized = false;
		this.id = -1;
	}

	public String[][] conjugate(Tense tense) {
		if (!initialized) {
			initConjugators();
		}
		switch (tense) {
		case PRESENT:
		case PRESENT_PASSIVE:
		case FUTURE:
		case FUTURE_PASSIVE:
		case IMPERFECT:
		case IMPERFECT_PASSIVE: {
			return conjugatorMappings.get(tense).inflect(stripDiacritics(presentFirst), stripDiacritics(genitive),
					tense);
		}
		case PERFECT:
		case PLUPERFECT:
		case FUTURE_PERFECT: {
			if (perfectFirst == null || perfectFirst.length() == 0) {
				return null;
			}
			return conjugatorMappings.get(tense).inflect(stripDiacritics(presentFirst), stripDiacritics(perfectFirst),
					tense);
		}
		case PERFECT_PASSIVE: {
			if (passiveFirst == null || passiveFirst.length() == 0) {
				return null;
			}
			return conjugatorMappings.get(tense).inflect(stripDiacritics(presentFirst), stripDiacritics(passiveFirst),
					tense);
		}
		default: {
			throw new IllegalArgumentException(tense.toString());
		}
		}
	}

	@Transient
	public String getDictionaryEntry() {
		StringBuilder sb = new StringBuilder();
		sb.append(presentFirst).append(",").append(genitive).append(",").append(perfectFirst).append(",")
				.append(passiveFirst);
		return sb.toString();
	}

	@Basic
	public int getConjugation() {
		return conjugation;
	}

	@Basic
	public String getPresentFirst() {
		return presentFirst;
	}

	@Basic
	public String getGenitive() {
		return genitive;
	}

	@Basic
	public String getPerfectFirst() {
		return perfectFirst;
	}

	@Basic
	public String getPassiveFirst() {
		return passiveFirst;
	}

	public void setConjugation(int conjugation) {
		this.conjugation = conjugation;
	}

	public void setPresentFirst(String presentFirst) {
		this.presentFirst = presentFirst;
	}

	public void setGenitive(String genitive) {
		this.genitive = genitive;
	}

	public void setPerfectFirst(String perfectFirst) {
		this.perfectFirst = perfectFirst;
	}

	public void setPassiveFirst(String passiveFirst) {
		this.passiveFirst = passiveFirst;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private void initConjugators() {

		Conjugator perfectPassiveConjugator = new CombiningConjugator(new UM2IFixer(new NullConjugator(3, 2)), " ",
				new SumConjugator());

		switch (conjugation) {
		case ConjugationMapper.FIRST_CONJ:
		case ConjugationMapper.SECOND_CONJ: {
			conjugatorMappings.put(Tense.PRESENT,
					new PresentStrapStemConjugator(new StemPlusPresentActiveEndingsConjugator()));
			conjugatorMappings.put(Tense.PRESENT_PASSIVE,
					new PresentStrapStemConjugator(new PassivePresentFixer(new StemPlusPassiveEndings())));
			conjugatorMappings.put(Tense.IMPERFECT, new PresentStrapStemConjugator(
					new AO2AmFixer(new BaConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.IMPERFECT_PASSIVE,
					new PresentStrapStemConjugator(new BaConjugator(new StemPlusPassiveEndings())));
			conjugatorMappings.put(Tense.FUTURE, new Int2UntFixer(new PresentStrapStemConjugator(
					new IO2OFixer(new BiConjugator(new StemPlusPresentActiveEndingsConjugator())))));
			conjugatorMappings.put(Tense.FUTURE_PASSIVE, new PresentStrapStemConjugator(new Int2UntFixer(
					new PassiveBerisFixer(new IR2ORFixer(new BiConjugator(new StemPlusPassiveEndings()))))));
			conjugatorMappings.put(Tense.PERFECT,
					new PerfectActiveStrapStemConjugator(new StemPlusPerfectActiveEndingsConjugator()));
			conjugatorMappings.put(Tense.PLUPERFECT, new PerfectActiveStrapStemConjugator(
					new AO2AmFixer(new EraConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.FUTURE_PERFECT, new PerfectActiveStrapStemConjugator(
					new IO2OFixer(new EriConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.PERFECT_PASSIVE, perfectPassiveConjugator);
			break;
		}
		case ConjugationMapper.THIRD_CONJ_O: {
			conjugatorMappings.put(Tense.PRESENT, new PresentStrapStemConjugator(
					new Int2UntFixer(new ConvertToIConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.IMPERFECT, new PresentStrapStemConjugator(
					new AO2AmFixer(new BaConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.FUTURE,
					new PresentStrapStemConjugator(new EO2AMFixer(new StemPlusPresentActiveEndingsConjugator())));
			conjugatorMappings.put(Tense.PERFECT,
					new PerfectActiveStrapStemConjugator(new StemPlusPerfectActiveEndingsConjugator()));
			conjugatorMappings.put(Tense.PLUPERFECT, new PerfectActiveStrapStemConjugator(
					new AO2AmFixer(new EraConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.FUTURE_PERFECT, new PerfectActiveStrapStemConjugator(
					new IO2OFixer(new EriConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.PRESENT_PASSIVE, new PresentStrapStemConjugator(new PassivePresentFixer(
					new IR2ERFixer(new Int2UntFixer(new ConvertToIConjugator(new StemPlusPassiveEndings()))))));
			conjugatorMappings.put(Tense.IMPERFECT_PASSIVE,
					new PresentStrapStemConjugator(new BaConjugator(new StemPlusPassiveEndings())));
			conjugatorMappings.put(Tense.FUTURE_PASSIVE,
					new PresentStrapStemConjugator(new E2EMacronFixer(new ER2ARFixer(new StemPlusPassiveEndings()))));
			conjugatorMappings.put(Tense.PERFECT_PASSIVE, perfectPassiveConjugator);
			break;
		}
		case ConjugationMapper.THIRD_CONJ_IO: {
			conjugatorMappings.put(Tense.PRESENT, new PresentStrapStemConjugator(
					new INT2IUNTFixer(new ConvertToIConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.IMPERFECT,
					new PresentStrapStemConjugator(new AO2AmFixer(new ConvertToIConjugator(
							new EConjugator(new BaConjugator(new StemPlusPresentActiveEndingsConjugator()))))));
			conjugatorMappings.put(Tense.FUTURE, new PresentStrapStemConjugator(new EO2AMFixer(
					new ConvertToIConjugator(new EConjugator(new StemPlusPresentActiveEndingsConjugator())))));
			conjugatorMappings.put(Tense.PERFECT,
					new PerfectActiveStrapStemConjugator(new StemPlusPerfectActiveEndingsConjugator()));
			conjugatorMappings.put(Tense.PLUPERFECT, new PerfectActiveStrapStemConjugator(
					new AO2AmFixer(new EraConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.FUTURE_PERFECT, new PerfectActiveStrapStemConjugator(
					new IO2OFixer(new EriConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.PRESENT_PASSIVE, new PresentStrapStemConjugator(new PassivePresentFixer(
					new IR2ERFixer(new INT2IUNTFixer(new ConvertToIConjugator(new StemPlusPassiveEndings()))))));
			conjugatorMappings.put(Tense.IMPERFECT_PASSIVE, new PresentStrapStemConjugator(
					new ConvertToIConjugator(new EConjugator(new BaConjugator(new StemPlusPassiveEndings())))));
			conjugatorMappings.put(Tense.FUTURE_PASSIVE, new PresentStrapStemConjugator(new E2EMacronFixer(
					new ER2ARFixer(new ConvertToIConjugator(new EConjugator(new StemPlusPassiveEndings()))))));
			conjugatorMappings.put(Tense.PERFECT_PASSIVE, perfectPassiveConjugator);
			break;
		}
		case ConjugationMapper.FOURTH_CONJ: {
			conjugatorMappings.put(Tense.PRESENT,
					new PresentStrapStemConjugator(new INT2IUNTFixer(new StemPlusPresentActiveEndingsConjugator())));
			conjugatorMappings.put(Tense.IMPERFECT, new PresentStrapStemConjugator(
					new AO2AmFixer(new EConjugator(new BaConjugator(new StemPlusPresentActiveEndingsConjugator())))));
			conjugatorMappings.put(Tense.FUTURE, new PresentStrapStemConjugator(
					new EO2AMFixer(new EConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.PERFECT,
					new PerfectActiveStrapStemConjugator(new StemPlusPerfectActiveEndingsConjugator()));
			conjugatorMappings.put(Tense.PLUPERFECT, new PerfectActiveStrapStemConjugator(
					new AO2AmFixer(new EraConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.FUTURE_PERFECT, new PerfectActiveStrapStemConjugator(
					new IO2OFixer(new EriConjugator(new StemPlusPresentActiveEndingsConjugator()))));
			conjugatorMappings.put(Tense.PRESENT_PASSIVE, new PresentStrapStemConjugator(
					new PassivePresentFixer(new INT2IUNTFixer(new StemPlusPassiveEndings()))));
			conjugatorMappings.put(Tense.IMPERFECT_PASSIVE,
					new PresentStrapStemConjugator(new EConjugator(new BaConjugator(new StemPlusPassiveEndings()))));
			conjugatorMappings.put(Tense.FUTURE_PASSIVE,
					new PresentStrapStemConjugator(new ER2ARFixer(new EConjugator(new StemPlusPassiveEndings()))));
			conjugatorMappings.put(Tense.PERFECT_PASSIVE, perfectPassiveConjugator);
		}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + conjugation;
		result = prime * result + ((genitive == null) ? 0 : genitive.hashCode());
		result = prime * result + (initialized ? 1231 : 1237);
		result = prime * result + ((passiveFirst == null) ? 0 : passiveFirst.hashCode());
		result = prime * result + ((perfectFirst == null) ? 0 : perfectFirst.hashCode());
		result = prime * result + ((presentFirst == null) ? 0 : presentFirst.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LatinVerb other = (LatinVerb) obj;
		if (conjugation != other.conjugation)
			return false;
		if (genitive == null) {
			if (other.genitive != null)
				return false;
		} else if (!genitive.equals(other.genitive))
			return false;
		if (initialized != other.initialized)
			return false;
		if (passiveFirst == null) {
			if (other.passiveFirst != null)
				return false;
		} else if (!passiveFirst.equals(other.passiveFirst))
			return false;
		if (perfectFirst == null) {
			if (other.perfectFirst != null)
				return false;
		} else if (!perfectFirst.equals(other.perfectFirst))
			return false;
		if (presentFirst == null) {
			if (other.presentFirst != null)
				return false;
		} else if (!presentFirst.equals(other.presentFirst))
			return false;
		return true;
	}

	private static String stripDiacritics(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
		return str;
	}

}
