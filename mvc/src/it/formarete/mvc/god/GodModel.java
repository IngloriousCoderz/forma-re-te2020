package it.formarete.mvc.god;

import java.util.ArrayList;
import java.util.List;

import it.formarete.mvc.Model;
import it.formarete.mvc.observer.Observer;

public class GodModel implements Model {
	private String attribute;
	private List<Observer> observers;

	public GodModel() {
		observers = new ArrayList<>();
	}

	@Override
	public String getAttribute() {
		return attribute;
	}

	@Override
	public void setAttribute(String attribute) {
		this.attribute = attribute;
		notifyObservers(attribute);
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	private void notifyObservers(String variable) {
		for (Observer observer : observers) {
			observer.wakeUp(variable);
		}
	}
}
