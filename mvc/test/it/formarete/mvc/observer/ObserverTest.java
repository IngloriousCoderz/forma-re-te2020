package it.formarete.mvc.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ObserverTest {

	@Test
	void test() {
		// given
		Observable observable = new Observable();
		Observer observer = new ObserverImpl();
		observable.addObserver(observer);

		// when
		observable.notifyObservers("hello world");

		// then
		assertEquals("hello world", ((ObserverImpl) observer).getMessage());
	}

}
