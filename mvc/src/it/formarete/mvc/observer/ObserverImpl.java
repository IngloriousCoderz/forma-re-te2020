package it.formarete.mvc.observer;

public class ObserverImpl implements Observer {
	private String message;

	@Override
	public void wakeUp(String variable) {
		message = variable;
	}

	public String getMessage() {
		return message;
	}
}
