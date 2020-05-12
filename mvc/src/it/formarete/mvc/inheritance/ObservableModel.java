package it.formarete.mvc.inheritance;

import it.formarete.mvc.Model;
import it.formarete.mvc.observer.Observable;

public class ObservableModel extends Observable implements Model {
	private String attribute;

	@Override
	public String getAttribute() {
		return attribute;
	}

	@Override
	public void setAttribute(String attribute) {
		this.attribute = attribute;
		notifyObservers(attribute);
	}
}
