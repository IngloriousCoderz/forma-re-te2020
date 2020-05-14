package it.formarete.apiserver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.formarete.apiserver.model.Todo;
import it.formarete.apiserver.services.TodosDB;

@SpringBootTest
public class TodosDBTest {
	@Autowired
	private TodosDB db;

//	@BeforeEach
//	public void init() {
//		db = new TodosDB();
//	}

	@Test
	public void shouldPerformCrudOperations() {
		shouldRead();
		Todo todo = shouldCreate();
		shouldUpdate(todo);
		shouldDelete(todo);
	}

	private void shouldRead() {
		assertThat(db.findAll().size(), is(3));
	}

	private Todo shouldCreate() {
		// when
		Todo todo = new Todo();
		todo.setText("Get fired");
		todo = db.save(todo);

		// then
		assertThat(db.findAll().size(), is(4));

		return todo;
	}

	private void shouldUpdate(Todo todo) {
		// when
		todo.setText("Get promoted");
		db.save(todo);

		// then
		assertThat(db.findById(todo.getId()).getText(), is("Get promoted"));
	}

	private void shouldDelete(Todo todo) {
		// when
		db.delete(todo);

		// then
		assertThat(db.findAll().size(), is(3));
	}
}
