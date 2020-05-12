package it.formarete.mario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.formarete.mario.state.BaseState;
import it.formarete.mario.state.CapeState;
import it.formarete.mario.state.FireState;
import it.formarete.mario.state.PowerState;
import it.formarete.mario.state.StatefulMario;
import it.formarete.mario.state.SuperState;

class StatefulMarioTest {

	@Test
	void testBaseMario() {
		Mario mario = new StatefulMario();
		((StatefulMario) mario).setState(new BaseState());

		assertEquals("", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testSuperMario() {
		Mario mario = new StatefulMario();
		((StatefulMario) mario).setState(new SuperState());

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testFireMario() {
		Mario mario = new StatefulMario();
		((StatefulMario) mario).setState(new FireState());

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Jumping", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testCapeMario() {
		Mario mario = new StatefulMario();
		((StatefulMario) mario).setState(new CapeState());

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Running", mario.onKeyPressed(KeyCode.ACTION));
	}

	@Test
	void testPowerMario() {
		Mario mario = new StatefulMario();
		((StatefulMario) mario).setState(new PowerState());

		assertEquals("Crashing", mario.onKeyPressed(KeyCode.DOWN));
		assertEquals("Gliding", mario.onKeyPressed(KeyCode.JUMP));
		assertEquals("Shooting", mario.onKeyPressed(KeyCode.ACTION));
	}
}
