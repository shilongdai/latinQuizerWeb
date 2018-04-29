package net.viperfish.latinQuiz.views;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import net.viperfish.latinQuiz.core.Tense;

@Component
public class StringToTenseConverter implements Converter<String, Tense> {

	public StringToTenseConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Tense convert(String arg0) {
		return Tense.valueOf(arg0);
	}

}
