package it.formarete.apiserver.services;

import org.springframework.data.repository.CrudRepository;

import it.formarete.apiserver.model.Todo;

public interface TodosRepository extends CrudRepository<Todo, Integer> {
	Todo findById(int id);
}
