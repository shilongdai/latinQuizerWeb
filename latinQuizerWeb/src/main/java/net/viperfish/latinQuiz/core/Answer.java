package net.viperfish.latinQuiz.core;

import java.util.List;

import org.apache.commons.lang3.tuple.Triple;

public interface Answer<T> {

	@Override
	boolean equals(Object arg0);

	List<? extends Triple<String, ? extends List<String>, String>> getSteps();

	List<? extends Triple<String, ? extends List<String>, String>> getSteps(T key);

}
