package it.formarete.mario.state;

import it.formarete.mario.KeyCode;

public interface State {
	public String onKeyPressed(KeyCode keyCode);
}
