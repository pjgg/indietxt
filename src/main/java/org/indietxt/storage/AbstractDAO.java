package org.indietxt.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractDAO<E> {

	private Collection<E> entities = new ArrayList<E>();

	public void addEntity(E entity) {
		entities.add(entity);
	}

	public Stream<E> filterEntities(Predicate<E> predicate) {
		return entities.stream().filter(predicate);
	}

	public boolean existEntities(Predicate<E> predicate) {
		return entities.stream().anyMatch(predicate);
	}


	public void removeEntities(Predicate<E> predicate) {
		List<E> tmp = filterEntities(predicate).collect(Collectors.toList());
		entities.removeAll(
				filterEntities(predicate).collect(Collectors.toList())
		);
	}

}
