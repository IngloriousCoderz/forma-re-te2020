package it.formarete.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.formarete.calculator.Calculator;
import it.formarete.calculator.god.GodCalculator;

class GodCalculatorTest {

	@Test
	void testCorrectInput() {
		Calculator calculator = new GodCalculator();

		assertEquals(5, calculator.sum(2, 3));
	}

	@Test
	void testIncorrectInput() {		
		Calculator calculator = new GodCalculator();
		
		assertThrows(IllegalArgumentException.class, () -> calculator.sum(null, 3));
	}
}
