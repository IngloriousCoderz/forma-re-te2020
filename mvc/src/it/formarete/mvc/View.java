package it.formarete.mvc;

import it.formarete.mvc.observer.Observer;

public class View implements Observer {
	private final static String TEMPLATE = "<h1>Hello ${variable}!</h1>";

	private String output;

	public View() {
		update("nobody");
	}

	public void update(String variable) {
		output = TEMPLATE.replace("${variable}", variable);
	}

	public String getOutput() {
		return output;
	}

	@Override
	public void wakeUp(String variable) {
		update(variable);
	}
}
