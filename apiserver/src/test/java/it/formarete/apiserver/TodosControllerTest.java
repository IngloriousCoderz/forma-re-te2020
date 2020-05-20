package it.formarete.apiserver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.formarete.apiserver.model.Todo;
import it.formarete.apiserver.presentation.NotFoundException;
import it.formarete.apiserver.presentation.TodosController;

@SpringBootTest
class TodosControllerTest {
	@Autowired
	private TodosController controller;

	@Test
	void shouldPerformCrudOperations() {
		shouldRetrieveAllTodos();
		shouldRetrieveById();
		shouldThrowIfNotFound();
		shouldAddTodo();
		shouldReplaceTodo();
		shouldMergeTodo();
		shouldRemoveTodo();
	}

	private void shouldRetrieveAllTodos() {
		List<Todo> todos = controller.all();
		assertThat(todos.size(), is(3));
	}

	private void shouldRetrieveById() {
		Todo todo = controller.get(2);
		assertThat(todo.getText(), is("Seek for a job"));
	}

	private void shouldThrowIfNotFound() {
		assertThrows(NotFoundException.class, () -> controller.get(4));
	}

	private void shouldAddTodo() {
		// given
		Todo body = new Todo();
		body.setText("Get promoted");
		body.setDone(false);

		// when
		controller.add(body);

		// then
		Todo todo = controller.get(4);
		assertThat(controller.all().size(), is(4));
		assertThat(todo.getText(), is("Get promoted"));
		assertThat(todo.getDone(), is(false));
	}

	private void shouldReplaceTodo() {
		// given
		Todo body = new Todo();
		body.setText("Seek for a job");
		body.setDone(true);

		// when
		controller.replace(2, body);

		// then
		Todo todo = controller.get(2);
		
		assertThat(todo.getText(), is(body.getText()));
		assertThat(todo.getDone(), is(true)); // not(is(false)), not(false), is(not(false))
	}

	private void shouldMergeTodo() {
		// given
		Todo body = new Todo();
		body.setText("Finish the course");

		// when
		controller.merge(2, body);

		// then
		Todo todo = controller.get(2);
		assertThat(todo.getText(), is(body.getText()));
		assertThat(todo.getDone(), is(true));
	}

	private void shouldRemoveTodo() {
		controller.remove(2);
		List<Todo> todos = controller.all();
		assertThat(todos.size(), is(3));
		assertThrows(NotFoundException.class, () -> controller.get(2));
	}
}
