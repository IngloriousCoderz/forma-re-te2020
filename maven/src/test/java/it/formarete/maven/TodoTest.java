package it.formarete.maven;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class TodoTest {
	@Test
	void test() {
		Todo todo = new Todo();
		todo.setId(1);
		todo.setText("Hello world");
		todo.setDone(true);

		assertThat(todo.toString(), is("Todo(id=1, text=Hello world, done=true)"));
	}
}
