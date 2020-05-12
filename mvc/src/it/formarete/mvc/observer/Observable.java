package it.formarete.mvc.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable {
	private List<Observer> observers;

	public Observable() {
		observers = new ArrayList<>();
	}

	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	public void notifyObservers(String variable) {
		for (Observer observer : observers) {
			observer.wakeUp(variable);
		}
	}
}
