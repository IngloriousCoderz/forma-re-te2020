package it.formarete.mario.state;

import it.formarete.mario.KeyCode;

public class SuperState extends BaseState {
	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case DOWN:
			return crash();

		default:
			return super.onKeyPressed(keyCode);
		}
	}

	private String crash() {
		return "Crashing";
	}
}
