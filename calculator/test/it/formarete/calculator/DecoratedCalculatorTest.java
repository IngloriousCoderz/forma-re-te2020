package it.formarete.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import it.formarete.calculator.proxy.BaseCalculator;
import it.formarete.calculator.proxy.LoggingProxy;
import it.formarete.calculator.proxy.ValidationProxy;

class DecoratedCalculatorTest {

	@Test
	void testCorrectInput() {
		Calculator calculator = new BaseCalculator();
		calculator = new ValidationProxy(calculator);
		calculator = new LoggingProxy(calculator);

		assertEquals(5, calculator.sum(2, 3));
	}

	@Test
	void testIncorrectInput() {
		Calculator calculator = new BaseCalculator();
		calculator = new ValidationProxy(calculator);
		calculator = new LoggingProxy(calculator);

		Calculator finalCalculator = calculator;

		assertThrows(IllegalArgumentException.class, () -> finalCalculator.sum(null, 3));
	}
}
