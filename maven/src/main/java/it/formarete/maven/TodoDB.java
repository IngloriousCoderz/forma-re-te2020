package it.formarete.maven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoDB {
	private static TodoDB instance;
	private static int id = 1;

	// eager initialization
//	static {
//		instance = new TodoDB();
//	}

	public static TodoDB getInstance() {
		// lazy initialization
		if (instance == null) {
			instance = new TodoDB();
		}
		return instance;
	}

	private Map<Integer, Todo> todos;

	private TodoDB() {
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
