package it.formarete.mario.decorator;

import it.formarete.mario.KeyCode;
import it.formarete.mario.Mario;

public class FireDecorator implements Mario {
	private Mario mario;

	public FireDecorator(Mario mario) {
		this.mario = mario;
	}

	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case ACTION:
			return shoot();

		default:
			return mario.onKeyPressed(keyCode);
		}
	}

	private String shoot() {
		return "Shooting";
	}
}
