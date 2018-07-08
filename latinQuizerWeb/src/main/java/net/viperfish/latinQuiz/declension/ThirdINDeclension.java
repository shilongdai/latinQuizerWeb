package net.viperfish.latinQuiz.declension;

public class ThirdINDeclension extends Declension {

	public ThirdINDeclension() {
		super(new String[][] { { "x", "ia" }, { "is", "ium" }, { "ī", "ibus" }, { "x", "ia" }, { "ī", "ibus" } });
	}

	@Override
	public String[][] decline(String first, String stem) {
		String[][] result = super.decline(first, stem);
		result[3][0] = result[0][0];
		return result;
	}

}
