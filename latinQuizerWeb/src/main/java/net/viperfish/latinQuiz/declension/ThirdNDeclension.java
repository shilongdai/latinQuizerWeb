package net.viperfish.latinQuiz.declension;

public class ThirdNDeclension extends Declension {

	public ThirdNDeclension() {
		super(new String[][] { { "x", "a" }, { "is", "um" }, { "ī", "ibus" }, { "x", "a" }, { "e", "ibus" } });
	}

	@Override
	public String[][] decline(String first, String stem) {
		String[][] result = super.decline(first, stem);
		result[3][0] = result[0][0];
		return result;
	}

}
