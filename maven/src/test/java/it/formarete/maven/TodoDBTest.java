package it.formarete.maven;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class TodoDBTest {
	private TodoDB db = TodoDB.getInstance();

	@Test
	void shouldPerformCrudOperations() {
		shouldRead();
		Todo todo = shouldCreate();
		shouldUpdate(todo);
		shouldDelete(todo);
	}

	private void shouldRead() {
		assertThat(db.findAll().size(), is(3));
	}

	private Todo shouldCreate() {
		Todo todo = new Todo();
		todo.setText("Get fired");
		todo = db.save(todo);

		assertThat(db.findById(todo.getId()).getText(), is("Get fired"));
		return todo;
	}

	private void shouldUpdate(Todo todo) {
		todo.setText("Get promoted");
		db.save(todo);

		assertThat(db.findById(todo.getId()).getText(), is("Get promoted"));
		assertThat(db.findAll().size(), is(4));
	}

	private void shouldDelete(Todo todo) {
		db.delete(todo);

		assertThat(db.findAll().size(), is(3));
	}
}
