package it.formarete.calculator.god;

import it.formarete.calculator.Calculator;

public class GodCalculator implements Calculator {
	@Override
	public int sum(Integer a, Integer b) {
		if (!isValid(a, b)) {
			throw new IllegalArgumentException("One of the two parameters is null");
		}

		return a + b;
	}

	private boolean isValid(Integer a, Integer b) {
		return a != null && b != null;
	}
}
