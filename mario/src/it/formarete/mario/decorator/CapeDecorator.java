package it.formarete.mario.decorator;

import it.formarete.mario.KeyCode;
import it.formarete.mario.Mario;

public class CapeDecorator implements Mario {
	private Mario mario;

	public CapeDecorator(Mario mario) {
		this.mario = mario;
	}

	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case JUMP:
			return glide();

		default:
			return mario.onKeyPressed(keyCode);
		}
	}

	private String glide() {
		return "Gliding";
	}
}
