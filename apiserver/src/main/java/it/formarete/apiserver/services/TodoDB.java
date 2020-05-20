package it.formarete.apiserver.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import it.formarete.apiserver.model.Todo;

@Repository
public class TodoDB {
	private static int id = 1;

	private Map<Integer, Todo> todos;

	public TodoDB() {
		todos = new HashMap<>();
		add("Learn Java", true);
		add("Seek for a job", false);
		add("Forget everything", null);
	}

	public List<Todo> findAll() {
		return new ArrayList<>(todos.values());
	}

	public Todo findById(Integer id) {
		return todos.get(id);
	}

	public void add(String text, Boolean done) {
		Todo todo = new Todo();
		todo.setText(text);
		todo.setDone(done);
		save(todo);
	}

	public Todo save(Todo todo) {
		boolean isNew = todo.getId() == null;
		if (isNew) {
			todo.setId(id);
			id++;
		}
		todos.put(todo.getId(), todo);
		return todo;
	}

	public void delete(Todo todo) {
		todos.remove(todo.getId());
	}
}
