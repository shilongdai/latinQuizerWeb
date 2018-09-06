package net.viperfish.latinQuiz.core;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LatinVerbDatabase extends CrudRepository<LatinVerb, Long> {

	List<LatinVerb> findAllByConjugationAndType(int conj, VerbType type);
}
