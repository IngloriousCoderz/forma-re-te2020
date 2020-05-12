package it.formarete.mvc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ViewModelTest {

	@Test
	void test() {
		// given
		Model model = new BaseModel();

		View view = new View();

		ViewModel vm = new ViewModel();
		vm.setModel(model);
		vm.setView(view);

		// when
		vm.handleInput("world");

		// then
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
