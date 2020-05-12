package it.formarete.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.formarete.calculator.strategy.CalculatorWith;
import it.formarete.calculator.strategy.Validator;

class CalculatorWithValidationTest {

	@Test
	void testCorrectInput() {
		Calculator calculator = new CalculatorWith(new Validator());

		assertEquals(5, calculator.sum(2, 3));
	}

	@Test
	void testIncorrectInput() {
		Calculator calculator = new CalculatorWith(new Validator());

		assertThrows(IllegalArgumentException.class, () -> calculator.sum(null, 3));
	}
}
