package it.formarete.mario.state;

import it.formarete.mario.KeyCode;
import it.formarete.mario.Mario;

public class StatefulMario implements Mario {
	private State state;

	@Override
	public String onKeyPressed(KeyCode keyCode) {
		return state.onKeyPressed(keyCode);
	}

	public void setState(State state) {
		this.state = state;
	}
}
