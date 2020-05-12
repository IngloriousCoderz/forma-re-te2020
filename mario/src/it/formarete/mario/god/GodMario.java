package it.formarete.mario.god;

import it.formarete.mario.KeyCode;
import it.formarete.mario.Mario;

public class GodMario implements Mario {
	private Type type;

	public GodMario(Type type) {
		this.type = type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String onKeyPressed(KeyCode keyCode) {
		switch (keyCode) {
		case LEFT:
			return moveLeft();

		case RIGHT:
			return moveRight();

		case DOWN:
			switch (type) {
			case SUPER:
			case FIRE:
			case CAPE:
			case POWER:
				return crash();

			default:
				return noop();
			}

		case JUMP:
			switch (type) {
			case CAPE:
			case POWER:
				return glide();

			default:
				return jump();
			}

		case ACTION:
			switch (type) {
			case FIRE:
			case POWER:
				return shoot();

			default:
				return run();
			}

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

	private String crash() {
		return "Crashing";
	}

	private String jump() {
		return "Jumping";
	}

	private String glide() {
		return "Gliding";
	}

	private String run() {
		return "Running";
	}

	private String shoot() {
		return "Shooting";
	}

	private String noop() {
		return "";
	}
}
