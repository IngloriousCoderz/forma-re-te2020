package it.formarete.mario.decorator;

import it.formarete.mario.KeyCode;
import it.formarete.mario.Mario;

public class SuperDecorator implements Mario {
	private Mario mario;

	public SuperDecorator(Mario mario) {
		this.mario = mario;
	}

	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case DOWN:
			return crash();

		default:
			return mario.onKeyPressed(keyCode);
		}
	}

	private String crash() {
		return "Crashing";
	}
}
