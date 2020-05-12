package it.formarete.mvc.decorator;

import it.formarete.mvc.Model;
import it.formarete.mvc.observer.Observable;

public class ObservableDecorator extends Observable implements Model {
	private Model model;

	public ObservableDecorator(Model model) {
		this.model = model;
	}

	@Override
	public String getAttribute() {
		return model.getAttribute();
	}

	@Override
	public void setAttribute(String attribute) {
		model.setAttribute(attribute);
		notifyObservers(attribute);
	}
}
