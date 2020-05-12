package it.formarete.mario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.formarete.mario.decorator.BaseMario;
import it.formarete.mario.decorator.CapeDecorator;
import it.formarete.mario.decorator.FireDecorator;
import it.formarete.mario.decorator.SuperDecorator;

class DecoratedMarioTest {

	@Test
	void testBaseMario() {
		Mario mario = new BaseMario();

		assertEquals("", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testSuperMario() {
		Mario mario = new BaseMario();
		mario = new SuperDecorator(mario);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testFireMario() {
		Mario mario = new BaseMario();
		mario = new SuperDecorator(mario);
		mario = new FireDecorator(mario);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testCapeMario() {
		Mario mario = new BaseMario();
		mario = new SuperDecorator(mario);
		mario = new CapeDecorator(mario);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testPowerMario() {
		Mario mario = new BaseMario();
		mario = new SuperDecorator(mario);
		mario = new FireDecorator(mario);
		mario = new CapeDecorator(mario);

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}
}
