package net.viperfish.latinQuiz.core;

import org.junit.Test;

public class TestThirdDeclension {

	@Test
	public void testThirdMfDeclension() {
		LatinNoun noun = new LatinNoun("rex", "regis", Gender.M, 2, NounType.REGULAR);
		String[][] expected = new String[][]{{"rex", "regēs"}, {"regis", "regum"}, {"regī", "regibus"},
				{"regem", "regēs"}, {"rege", "regibus"}};
		String[][] actual = noun.inflect();
		TestUtils.test(expected, actual);
	}

	@Test
	public void testThirdNDeclension() {
		LatinNoun noun = new LatinNoun("carmen", "carminis", Gender.N, 2, NounType.REGULAR);
		String[][] expected = new String[][]{{"carmen", "carmina"}, {"carminis", "carminum"},
				{"carminī", "carminibus"}, {"carmen", "carmina"}, {"carmine", "carminibus"}};
		String[][] actual = noun.inflect();
		TestUtils.test(expected, actual);
	}

	@Test
	public void testThirdIODeclension() {
		LatinNoun noun = new LatinNoun("civis", "civis", Gender.M, 2, NounType.IA);
		String[][] expected = new String[][]{{"civis", "civēs"}, {"civis", "civium"},
				{"civī", "civibus"},
				{"civem", "civēs"}, {"cive", "civibus"}};
		String[][] actual = noun.inflect();
		TestUtils.test(expected, actual);
	}

	@Test
	public void testThirdIONDeclension() {
		LatinNoun noun = new LatinNoun("mare", "maris", Gender.N, 2, NounType.IA);
		String[][] expected = new String[][]{{"mare", "maria"}, {"maris", "marium"},
				{"marī", "maribus"},
				{"mare", "maria"}, {"marī", "maribus"}};
		String[][] actual = noun.inflect();
		TestUtils.test(expected, actual);
	}

}
