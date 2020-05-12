package it.formarete.mario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.formarete.mario.god.GodMario;
import it.formarete.mario.god.Type;

class GodMarioTest {

	@Test
	void testBaseMario() {
		Mario mario = new GodMario(Type.BASE);

		assertEquals("", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testSuperMario() {
//		Mario mario = new GodMario(Type.BASE);
//		((GodMario) mario).setType(Type.SUPER);
		Mario mario = new GodMario(Type.SUPER);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testFireMario() {
		Mario mario = new GodMario(Type.FIRE);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testCapeMario() {
		Mario mario = new GodMario(Type.CAPE);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testPowerMario() {
		Mario mario = new GodMario(Type.POWER);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}
}
