package it.formarete.mvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.formarete.mvc.decorator.ObservableDecorator;
import it.formarete.mvc.god.GodModel;
import it.formarete.mvc.inheritance.ObservableModel;
import it.formarete.mvc.observer.Observable;
import it.formarete.mvc.strategy.ModelWithObservable;

class ControllerTest {

	@Test
	void testGodObject() {
		// given
		Model model = new GodModel();

		View view = new View();
		((GodModel) model).addObserver(view);
		Logger logger = new Logger();
		((GodModel) model).addObserver(logger);

		Controller controller = new Controller();
		controller.setModel(model);

		// when
		controller.handleInput("world");

		// then
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}

	@Test
	void testInheritance() {
		// given
		Model model = new ObservableModel();

		View view = new View();
		((Observable) model).addObserver(view);
		Logger logger = new Logger();
		((Observable) model).addObserver(logger);

		Controller controller = new Controller();
		controller.setModel(model);

		// when
		controller.handleInput("world");

		// then
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}

	@Test
	void testStrategy() {
		// given
		Model model = new ModelWithObservable();

		View view = new View();
//		model.getObservable().addObserver(view);
		((ModelWithObservable) model).addObserver(view);
		Logger logger = new Logger();
		((ModelWithObservable) model).addObserver(logger);

		Controller controller = new Controller();
		controller.setModel(model);

		// when
		controller.handleInput("world");

		// then
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}

	@Test
	void testDecorator() {
		// given
		Model model = new BaseModel();
		model = new ObservableDecorator(model);

		View view = new View();
		((Observable) model).addObserver(view);
		Logger logger = new Logger();
		((Observable) model).addObserver(logger);

		Controller controller = new Controller();
		controller.setModel(model);

		// when
		controller.handleInput("world");

		// then
		assertEquals("world", model.getAttribute());
		assertEquals("<h1>Hello world!</h1>", view.getOutput());
	}
}
