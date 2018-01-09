package net.viperfish.latinQuiz.inflector;

import java.util.HashMap;
import java.util.Map;

import net.viperfish.latinQuiz.core.Conjugator;
import net.viperfish.latinQuiz.core.Tense;

@Deprecated
public class StemPlusEndingConjugator implements Conjugator {

	private final static Map<Tense, String[][]> tenseTable;

	static {
		tenseTable = new HashMap<>();
		String[][] endingsPresent = { { "o", "mus" }, { "s", "tis" }, { "t", "nt" } };
		String[][] endingsImperfect = { { "bam", "bamus" }, { "bas", "batis" }, { "bat", "bant" } };
		String[][] endingsFuture = { { "bo", "bimus" }, { "bis", "bitis" }, { "bit", "bunt" } };
		String[][] endingsPerfect = { { "i", "imus" }, { "isti", "itis" }, { "it", "erunt" } };
		String[][] endingsPluPerfect = { { "eram", "eramus" }, { "eras", "eratis" }, { "erat", "erant" } };
		String[][] endingsFutureperfect = { { "ero", "erimus" }, { "eris", "eritis" }, { "erit", "erint" } };
		String[][] presentPassiveEndings = { { "r", "mur" }, { "ris", "mini" }, { "tur", "ntur" } };
		String[][] imperfectPassiveEndings = { { "bar", "bamur" }, { "baris", "bamini" }, { "batur", "bantur" } };
		String[][] futurePassiveEndings = { { "bor", "bimur" }, { "beris", "bimini" }, { "bitur", "buntur" } };
		tenseTable.put(Tense.PRESENT, endingsPresent);
		tenseTable.put(Tense.IMPERFECT, endingsImperfect);
		tenseTable.put(Tense.FUTURE, endingsFuture);
		tenseTable.put(Tense.PERFECT, endingsPerfect);
		tenseTable.put(Tense.PLUPERFECT, endingsPluPerfect);
		tenseTable.put(Tense.FUTURE_PERFECT, endingsFutureperfect);
		tenseTable.put(Tense.PRESENT_PASSIVE, presentPassiveEndings);
		tenseTable.put(Tense.IMPERFECT_PASSIVE, imperfectPassiveEndings);
		tenseTable.put(Tense.FUTURE_PASSIVE, futurePassiveEndings);
	}

	@Override
	public String[][] inflect(String first, String stem, Tense t) {
		String[][] endings = tenseTable.get(t);
		String[][] result = new String[endings.length][];
		for (int i = 0; i < result.length; ++i) {
			result[i] = new String[endings[i].length];
		}
		for (int i = 0; i < endings.length; ++i) {
			for (int j = 0; j < endings[i].length; ++j) {
				result[i][j] = stem + endings[i][j];
			}
		}
		return result;
	}

}
