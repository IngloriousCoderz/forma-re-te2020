package it.formarete.mario.inheritance;

import it.formarete.mario.KeyCode;

public class CapeMario extends SuperMario {
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
