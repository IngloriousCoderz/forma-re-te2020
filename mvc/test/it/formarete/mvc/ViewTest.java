package it.formarete.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ViewTest {
	@Test
	void shouldInit() {
		// given
		View view = new View();

		// when

		// then
		assertEquals("<h1>Hello nobody!</h1>", view.getOutput());
	}

	@Test
	void shouldUpdate() {
		// given
		View view = new View();

		// when
		view.update("world");

		// then
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}

}
