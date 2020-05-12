package it.formarete.mario.state;

import it.formarete.mario.KeyCode;

public class FireState extends SuperState {
	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case ACTION:
			return shoot();

		default:
			return super.onKeyPressed(keyCode);
		}
	}

	private String shoot() {
		return "Shooting";
	}
}
