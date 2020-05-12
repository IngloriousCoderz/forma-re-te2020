package it.formarete.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.formarete.mvc.god.GodModel;

class ControllerTest {

	@Test
	void test() {
		// given
		Model model = new GodModel();

		View view = new View();
		((GodModel) model).addObserver(view);
		// Logger -> System.out.println(variable)

		Controller controller = new Controller();
		controller.setModel(model);

		// when
		controller.handleInput("world");

		// then
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}

}
