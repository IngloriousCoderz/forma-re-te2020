package it.formarete.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testSum() {
		// given
		Calculator calc = new CalculatorImpl();

		// when
		int sum = calc.sum(2, 3);

		// then
		assertEquals(5, sum);
	}

	@Test
	void testSumAnyNumber() {
		// given
		Calculator calc = new CalculatorImpl();

		// when
		int sum = calc.sum(5, 7);

		// then
		assertEquals(12, sum);
	}
}
