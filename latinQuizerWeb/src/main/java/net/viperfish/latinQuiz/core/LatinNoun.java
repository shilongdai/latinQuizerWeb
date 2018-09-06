package net.viperfish.latinQuiz.core;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import net.viperfish.latinQuiz.declension.FirstGenericDeclension;
import net.viperfish.latinQuiz.declension.FourthMDeclension;
import net.viperfish.latinQuiz.declension.FourthNDeclension;
import net.viperfish.latinQuiz.declension.SecondMDeclension;
import net.viperfish.latinQuiz.declension.SecondNDeclension;
import net.viperfish.latinQuiz.declension.ThirdIMFDeclension;
import net.viperfish.latinQuiz.declension.ThirdINDeclension;
import net.viperfish.latinQuiz.declension.ThirdMFDeclension;
import net.viperfish.latinQuiz.declension.ThirdNDeclension;

@Entity
@Table(name = "Nouns")
public class LatinNoun {

	private static final Map<Integer, Map<Gender, Map<NounType, NounDecliner>>> decliners;
	private static final Map<Integer, String> genitiveEndings;

	static {
		decliners = new HashMap<Integer, Map<Gender, Map<NounType, NounDecliner>>>();
		genitiveEndings = new HashMap<Integer, String>();
		for (int i = 0; i < 10; ++i) {
			decliners.put(i, new HashMap<Gender, Map<NounType, NounDecliner>>());
			for (Gender g : Gender.values()) {
				decliners.get(i).put(g, new HashMap<NounType, NounDecliner>());
			}
		}
		initDecliners();
		initGenitiveEndings();
	}

	private String nomSing;
	private String genitive;
	private Gender gender;
	private int declension;
	private NounType type;
	private long id;
	public LatinNoun() {
		this.id = -1;
		nomSing = "";
		genitive = "";
		gender = Gender.N;
		declension = -1;
		type = NounType.IA;
	}
	public LatinNoun(String nomSing, String genitive, Gender gender, int declension, NounType type) {
		super();
		this.id = -1;
		this.nomSing = nomSing;
		this.genitive = genitive;
		this.gender = gender;
		this.declension = declension;
		this.type = type;

	}

	private static void initDecliners() {
		decliners.get(0).get(Gender.F).put(NounType.REGULAR, new FirstGenericDeclension());
		decliners.get(0).get(Gender.M).put(NounType.REGULAR, new FirstGenericDeclension());
		decliners.get(1).get(Gender.M).put(NounType.REGULAR, new SecondMDeclension());
		decliners.get(1).get(Gender.N).put(NounType.REGULAR, new SecondNDeclension());
		decliners.get(2).get(Gender.M).put(NounType.REGULAR, new ThirdMFDeclension());
		decliners.get(2).get(Gender.F).put(NounType.REGULAR, new ThirdMFDeclension());
		decliners.get(2).get(Gender.N).put(NounType.REGULAR, new ThirdNDeclension());
		decliners.get(2).get(Gender.M).put(NounType.IA, new ThirdIMFDeclension());
		decliners.get(2).get(Gender.F).put(NounType.IA, new ThirdIMFDeclension());
		decliners.get(2).get(Gender.N).put(NounType.IA, new ThirdINDeclension());
		decliners.get(3).get(Gender.M).put(NounType.REGULAR, new FourthMDeclension());
		decliners.get(3).get(Gender.N).put(NounType.REGULAR, new FourthNDeclension());
	}

	private static void initGenitiveEndings() {
		genitiveEndings.put(0, "ae");
		genitiveEndings.put(1, "ī");
		genitiveEndings.put(2, "is");
		genitiveEndings.put(3, "ūs");
		genitiveEndings.put(4, "eī");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	public String getNomSing() {
		return nomSing;
	}

	public void setNomSing(String nomSing) {
		this.nomSing = nomSing;
	}

	@Basic
	public String getGenitive() {
		return genitive;
	}

	public void setGenitive(String genitive) {
		this.genitive = genitive;
	}

	@Basic
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Basic
	public int getDeclension() {
		return declension;
	}

	public void setDeclension(int declension) {
		this.declension = declension;
	}

	@Basic
	public NounType getType() {
		return type;
	}

	public void setType(NounType type) {
		this.type = type;
	}

	public String[][] inflect() {
		NounDecliner dec = decliners.get(declension).get(gender).get(type);
		if (dec == null) {
			return null;
		}
		return dec.decline(nomSing, createStem());

	}

	public String[][] inflect(int dec, Gender g, NounType n) {
		NounDecliner dc = decliners.get(dec).get(g).get(n);
		if (dc == null) {
			return null;
		}
		return dc.decline(nomSing, createStem());
	}

	private String createStem() {
		return genitive.substring(0, genitive.lastIndexOf(genitiveEndings.get(declension)));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + declension;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((genitive == null) ? 0 : genitive.hashCode());
		result = prime * result + ((nomSing == null) ? 0 : nomSing.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LatinNoun other = (LatinNoun) obj;
		if (declension != other.declension) {
			return false;
		}
		if (gender != other.gender) {
			return false;
		}
		if (genitive == null) {
			if (other.genitive != null) {
				return false;
			}
		} else if (!genitive.equals(other.genitive)) {
			return false;
		}
		if (nomSing == null) {
			if (other.nomSing != null) {
				return false;
			}
		} else if (!nomSing.equals(other.nomSing)) {
			return false;
		}
		return type == other.type;
	}

	@Override
	public String toString() {
		return "LatinNoun [nomSing=" + nomSing + ", genitive=" + genitive + ", gender=" + gender
				+ ", declension="
				+ declension + ", type=" + type + ", id=" + id + "]";
	}

}
