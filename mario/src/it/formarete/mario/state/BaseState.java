package it.formarete.mario.state;

import it.formarete.mario.KeyCode;

public class BaseState implements State {
	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case LEFT:
			return moveLeft();

		case RIGHT:
			return moveRight();

		case JUMP:
			return jump();

		case ACTION:
			return run();

		default:
			return noop();
		}
	}

	private String moveLeft() {
		return "Moving left";
	}

	private String moveRight() {
		return "Moving right";
	}

	private String jump() {
		return "Jumping";
	}

	private String run() {
		return "Running";
	}

	private String noop() {
		return "";
	}
}
