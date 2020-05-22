package it.formarete.apiserver.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.formarete.apiserver.model.Todo;
import it.formarete.apiserver.model.User;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
	List<Todo> findAll();

	Todo findById(int id);

	List<Todo> findByAuthor(User author);
}
