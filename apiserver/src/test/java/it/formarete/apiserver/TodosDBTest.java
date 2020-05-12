package it.formarete.apiserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.formarete.apiserver.model.Todo;
import it.formarete.apiserver.services.TodosDB;

public class TodosDBTest {

	@Test
	public void testCrud() {
		// given
		TodosDB db = new TodosDB();
		assertEquals(3, db.findAll().size());

		Todo todo = testC(db);
		testU(todo, db);
		testD(todo, db);
	}

	private Todo testC(TodosDB db) {
		// when
		Todo todo = new Todo();
		todo.setText("Get fired");
		todo = db.save(todo);

		// then
		assertEquals(4, db.findAll().size());

		return todo;
	}

	private void testU(Todo todo, TodosDB db) {
		// when
		todo.setText("Get promoted");
		db.save(todo);

		// then
		assertEquals("Get promoted", db.findById(todo.getId()).getText());
	}

	private void testD(Todo todo, TodosDB db) {
		// when
		db.delete(todo);

		// then
		assertEquals(3, db.findAll().size());
	}
}
