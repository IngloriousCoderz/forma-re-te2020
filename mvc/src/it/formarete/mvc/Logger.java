package it.formarete.mvc;

import it.formarete.mvc.observer.Observer;

public class Logger implements Observer {
	@Override
	public void wakeUp(String variable) {
		System.out.println(variable);
	}
}
