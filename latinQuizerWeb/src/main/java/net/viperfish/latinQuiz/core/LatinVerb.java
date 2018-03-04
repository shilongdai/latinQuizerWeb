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

import net.viperfish.latinQuiz.conjugators.DeponentSubjunctiveConjugator;
import net.viperfish.latinQuiz.conjugators.FirstDeponentConjugator;
import net.viperfish.latinQuiz.conjugators.FirstSecondIndicActiveConjugator;
import net.viperfish.latinQuiz.conjugators.FirstSecondIndicPassiveConjugator;
import net.viperfish.latinQuiz.conjugators.FourthDeponentConjugator;
import net.viperfish.latinQuiz.conjugators.FourthIndicActiveConjugator;
import net.viperfish.latinQuiz.conjugators.FourthIndicPassiveConjugator;
import net.viperfish.latinQuiz.conjugators.SubjunctiveActiveConjugator;
import net.viperfish.latinQuiz.conjugators.SubjunctivePassiveConjugator;
import net.viperfish.latinQuiz.conjugators.ThirdDeponentConjugator;
import net.viperfish.latinQuiz.conjugators.ThirdIODeponentConjugator;
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
	private int conjugation;
	private String presentFirst;
	private String genitive;
	private String perfectFirst;
	private String passiveFirst;
	private VerbType type;
	@Transient
	private Map<Tense, VerbRule> conjugatorMappings;

	private static final Pattern DIACRITICS_AND_FRIENDS = Pattern
			.compile("[\\p{InCombiningDiacriticalMarks}\\p{IsLm}\\p{IsSk}]+");
	private static final Map<VerbType, Map<Integer, Map<Mood, Map<Voice, Conjugator>>>> conjugators;

	static {
		conjugators = new HashMap<>();
		createMaps();
		initFirstSecondDec();
		initThirdODec();
		initThirdIODec();
		initFourthDec();
	}

	public LatinVerb(int conjugation, String presentFirst, String genitive, String perfectFirst, String passiveFirst,
			VerbType type) {
		this();
		this.conjugation = conjugation;
		this.presentFirst = presentFirst;
		this.genitive = genitive;
		this.perfectFirst = perfectFirst;
		this.passiveFirst = passiveFirst;
		this.type = type;
	}

	public LatinVerb() {
		super();
		conjugatorMappings = new HashMap<>();
		this.id = -1;
		type = VerbType.REGULAR;
	}

	public String[][] conjugate(Mood mood, Voice voice, Tense tense) {
		Conjugator c = conjugators.get(this.type).get(conjugation).get(mood).get(voice);
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

	@Basic
	public VerbType getType() {
		return type;
	}

	public void setType(VerbType type) {
		this.type = type;
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
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (type != other.type)
			return false;
		return true;
	}

	private static String stripDiacritics(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = DIACRITICS_AND_FRIENDS.matcher(str).replaceAll("");
		return str;
	}

	private static void createMaps() {
		for (VerbType v : VerbType.values()) {
			conjugators.put(v, new HashMap<Integer, Map<Mood, Map<Voice, Conjugator>>>());
			for (int i = 0; i < 6; ++i) {
				conjugators.get(v).put(i, new HashMap<Mood, Map<Voice, Conjugator>>());
				conjugators.get(v).get(i).put(Mood.INDICATIVE, new HashMap<Voice, Conjugator>());
				conjugators.get(v).get(i).put(Mood.SUBJUNCTIVE, new HashMap<Voice, Conjugator>());
			}
		}
	}

	private static void initFirstSecondDec() {

		// regular verbs
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FIRST_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FirstSecondIndicActiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FIRST_CONJ).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new FirstSecondIndicPassiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.SECOND_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FirstSecondIndicActiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.SECOND_CONJ).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new FirstSecondIndicPassiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FIRST_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new SubjunctiveActiveConjugator(ConjugationMapper.FIRST_CONJ));
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.SECOND_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new SubjunctiveActiveConjugator(ConjugationMapper.SECOND_CONJ));
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FIRST_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.PASSIVE,
				new SubjunctivePassiveConjugator(ConjugationMapper.FIRST_CONJ));
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.SECOND_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.PASSIVE,
				new SubjunctivePassiveConjugator(ConjugationMapper.SECOND_CONJ));

		// deponent verbs
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.FIRST_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FirstDeponentConjugator());
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.SECOND_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FirstDeponentConjugator());
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.FIRST_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new DeponentSubjunctiveConjugator(ConjugationMapper.FIRST_CONJ));
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.SECOND_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new DeponentSubjunctiveConjugator(ConjugationMapper.SECOND_CONJ));

	}

	private static void initThirdODec() {

		// regular verbs
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_O).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new ThirdOIndicActiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_O).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new ThirdOIndicPassiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_O).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new SubjunctiveActiveConjugator(ConjugationMapper.THIRD_CONJ_O));
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_O).get(Mood.SUBJUNCTIVE).put(Voice.PASSIVE,
				new SubjunctivePassiveConjugator(ConjugationMapper.THIRD_CONJ_O));

		// deponent verbs
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.THIRD_CONJ_O).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new ThirdDeponentConjugator());
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.THIRD_CONJ_O).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new DeponentSubjunctiveConjugator(ConjugationMapper.THIRD_CONJ_O));
	}

	private static void initThirdIODec() {
		// regular verbs
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new ThirdIOIndicActiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new ThirdIOIndicPassiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new SubjunctiveActiveConjugator(ConjugationMapper.THIRD_CONJ_IO));
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.SUBJUNCTIVE).put(Voice.PASSIVE,
				new SubjunctivePassiveConjugator(ConjugationMapper.THIRD_CONJ_IO));

		// deponent verbs
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new ThirdIODeponentConjugator());
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.THIRD_CONJ_IO).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new DeponentSubjunctiveConjugator(ConjugationMapper.THIRD_CONJ_IO));
	}

	private static void initFourthDec() {

		// regular verbs
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FOURTH_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FourthIndicActiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FOURTH_CONJ).get(Mood.INDICATIVE).put(Voice.PASSIVE,
				new FourthIndicPassiveConjugator());
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FOURTH_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new SubjunctiveActiveConjugator(ConjugationMapper.FIRST_CONJ));
		conjugators.get(VerbType.REGULAR).get(ConjugationMapper.FOURTH_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.PASSIVE,
				new SubjunctivePassiveConjugator(ConjugationMapper.FOURTH_CONJ));

		// deponent verbs
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.FOURTH_CONJ).get(Mood.INDICATIVE).put(Voice.ACTIVE,
				new FourthDeponentConjugator());
		conjugators.get(VerbType.DEPONENT).get(ConjugationMapper.FOURTH_CONJ).get(Mood.SUBJUNCTIVE).put(Voice.ACTIVE,
				new DeponentSubjunctiveConjugator(ConjugationMapper.FOURTH_CONJ));
	}

}
