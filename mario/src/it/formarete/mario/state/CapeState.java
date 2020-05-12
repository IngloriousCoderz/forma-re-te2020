package it.formarete.mario.state;

import it.formarete.mario.KeyCode;

public class CapeState extends SuperState {
	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case JUMP:
			return glide();

		default:
			return super.onKeyPressed(keyCode);
		}
	}

	private String glide() {
		return "Gliding";
	}
}
