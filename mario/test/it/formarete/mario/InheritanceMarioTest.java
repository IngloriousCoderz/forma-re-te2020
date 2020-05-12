package it.formarete.mario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.formarete.mario.inheritance.BaseMario;
import it.formarete.mario.inheritance.CapeMario;
import it.formarete.mario.inheritance.FireMario;
import it.formarete.mario.inheritance.PowerMario;
import it.formarete.mario.inheritance.SuperMario;

class InheritanceMarioTest {

	@Test
	void testBaseMario() {
		Mario mario = new BaseMario();

		assertEquals("", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testSuperMario() {
//		Mario mario = new BaseMario();
//		mario = new SuperMario();
		Mario mario = new SuperMario();

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testFireMario() {
		Mario mario = new FireMario();

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testCapeMario() {
		Mario mario = new CapeMario();

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testPowerMario() {
		Mario mario = new PowerMario();

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}
}
