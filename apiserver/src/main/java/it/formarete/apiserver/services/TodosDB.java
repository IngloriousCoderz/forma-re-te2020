package it.formarete.apiserver.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import it.formarete.apiserver.model.Todo;

@Repository
public class TodosDB {
	private final Map<Integer, Todo> todos;
	private static int id = 1;

	public TodosDB() {
		todos = new HashMap<>();
		add("Learn Java", true);
		add("Seek for a job", false);
		add("Forget everything", null);
	}

	public List<Todo> findAll() {
		return new ArrayList<>(todos.values());
	}

	public Todo findById(int id) {
		return todos.get(id);
	}

	private Todo add(String text, Boolean done) {
		Todo todo = new Todo();
		todo.setText(text);
		todo.setDone(done);
		return save(todo);
	}

	public Todo save(Todo todo) {
		boolean isNew = todo.getId() == null;
		if (isNew) {
			todo.setId(id);
			id++;
		}

		todos.put(todo.getId(), todo);
		return todos.get(todo.getId());
	}

	public void delete(Todo todo) {
		todos.remove(todo.getId());
	}
}