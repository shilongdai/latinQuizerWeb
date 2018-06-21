package net.viperfish.latinQuiz.core;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LatinNounDatabase extends CrudRepository<LatinNoun, Long> {
	public List<LatinNoun> findAllByDeclensionAndGenderAndType(int declension, Gender gender, NounType type);
}
