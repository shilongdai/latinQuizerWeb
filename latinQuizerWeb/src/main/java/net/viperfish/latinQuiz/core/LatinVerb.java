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

import net.viperfish.latinQuiz.conjugators.FirstSecondIndicActiveConjugator;
import net.viperfish.latinQuiz.conjugators.FirstSecondIndicPassiveConjugator;
import net.viperfish.latinQuiz.conjugators.FourthIndicActiveConjugator;
import net.viperfish.latinQuiz.conjugators.FourthIndicPassiveConjugator;
import net.viperfish.latinQuiz.conjugators.ThirdIOIndicActiveConjugator;
import net.viperfish.latinQuiz.conjugators.ThirdIOIndicPassiveConjugator;
import net.viperfish.latinQuiz.conjugators.ThirdOIndicActiveConjugator;
import net.viperfish.latinQuiz.conjugators.ThirdOIndicPassiveConjugator;

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
	private Map<Tense, VerbRule> conjugatorMappings;

	private static final Pattern DIACRITICS_AND_FRIENDS = Pattern
			.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");
	private static final Map<Integer, Map<Mood, Map<Voice, Conjugator>>> conjugators;

	static {
		conjugators = new HashMap<>();
		createMaps();
		initFirstSecondDec();
		initThirdODec();
		initThirdIODec();
		initFourthDec();
	}

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
		this.id = -1;
	}

	public String[][] conjugate(Mood mood, Voice voice, Tense tense) {
		Conjugator c = conjugators.get(conjugation).get(mood).get(voice);
		if (c == null) {
			return new String[0][0];
		}
		return c.conjugate(tense, stripDiacritics(presentFirst), stripDiacritics(genitive),
				stripDiacritics(perfectFirst), stripDiacritics(passiveFirst));
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + conjugation;
		result = prime * result + ((genitive == null) ? 0 : genitive.hashCode());
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

	private static void createMaps() {
		for (int i = 0; i < 6; ++i) {
			conjugators.put(i, new HashMap<Mood, Map<Voice, Conjugator>>());
			conjugators.get(i).put(Mood.INDICATIVE, new HashMap<Voice, Conjugator>());
			conjugators.get(i).put(Mood.SUBJUNCTIVE, new HashMap<Voice, Conjugator>());
		}
	}

	private static void initFirstSecondDec() {
		conjugators.get(ConjugationMapper.FIRST_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FirstSecondIndicActiveConjugator());
		conjugators.get(ConjugationMapper.FIRST_CONJ).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new FirstSecondIndicPassiveConjugator());
		conjugators.get(ConjugationMapper.SECOND_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FirstSecondIndicActiveConjugator());
		conjugators.get(ConjugationMapper.SECOND_CONJ).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new FirstSecondIndicPassiveConjugator());
	}

	private static void initThirdODec() {
		conjugators.get(ConjugationMapper.THIRD_CONJ_O).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new ThirdOIndicActiveConjugator());
		conjugators.get(ConjugationMapper.THIRD_CONJ_O).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new ThirdOIndicPassiveConjugator());
	}

	private static void initThirdIODec() {
		conjugators.get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new ThirdIOIndicActiveConjugator());
		conjugators.get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new ThirdIOIndicPassiveConjugator());
	}

	private static void initFourthDec() {
		conjugators.get(ConjugationMapper.FOURTH_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FourthIndicActiveConjugator());
		conjugators.get(ConjugationMapper.FOURTH_CONJ).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new FourthIndicPassiveConjugator());
	}

}
