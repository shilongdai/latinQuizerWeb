package net.viperfish.latinQuizer.quizers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.viperfish.latinQuiz.core.LatinVerb;
import net.viperfish.latinQuiz.core.LatinVerbDatabase;

public final class MockLatinVerbDatabase implements LatinVerbDatabase {

	private Map<Long, LatinVerb> mapper;
	private long currentId;

	public MockLatinVerbDatabase() {
		mapper = new HashMap<>();
		currentId = 0;
	}

	@Override
	public long count() {
		return mapper.size();
	}

	@Override
	public void delete(Long id) {
		mapper.remove(id);
	}

	@Override
	public void delete(LatinVerb entity) {
		mapper.remove(entity.getId());
	}

	@Override
	public void delete(Iterable<? extends LatinVerb> entities) {
		for (LatinVerb l : entities) {
			delete(l);
		}
	}

	@Override
	public void deleteAll() {
		mapper.clear();
	}

	@Override
	public boolean exists(Long id) {
		return !(mapper.get(id) == null);
	}

	@Override
	public Iterable<LatinVerb> findAll() {
		List<LatinVerb> results = new LinkedList<>();
		for (Entry<Long, LatinVerb> e : mapper.entrySet()) {
			results.add(e.getValue());
		}
		return results;
	}

	@Override
	public Iterable<LatinVerb> findAll(Iterable<Long> ids) {
		List<LatinVerb> results = new LinkedList<>();
		for (Long i : ids) {
			results.add(mapper.get(i));
		}
		return results;
	}

	@Override
	public LatinVerb findOne(Long id) {
		return mapper.get(id);
	}

	@Override
	public <S extends LatinVerb> S save(S entity) {
		entity.setId(currentId++);
		mapper.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public <S extends LatinVerb> Iterable<S> save(Iterable<S> entities) {
		for (LatinVerb v : entities) {
			save(v);
		}
		return entities;
	}

	@Override
	public List<LatinVerb> findAllByConjugation(int conj) {
		List<LatinVerb> result = new LinkedList<>();
		for (Entry<Long, LatinVerb> e : mapper.entrySet()) {
			if (e.getValue().getConjugation() == conj) {
				result.add(e.getValue());
			}
		}
		return result;
	}

}
