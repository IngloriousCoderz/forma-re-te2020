package it.formarete.mario.state;

import it.formarete.mario.KeyCode;

public class PowerState extends SuperState {
	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case JUMP:
			return glide();

		case ACTION:
			return shoot();

		default:
			return super.onKeyPressed(keyCode);
		}
	}

	private String shoot() {
		return "Shooting";
	}

	private String glide() {
		return "Gliding";
	}
}
