package it.formarete.calculator.proxy;

import it.formarete.calculator.Calculator;

public class ValidationProxy implements Calculator {
	private Calculator calculator;

	public ValidationProxy(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public int sum(Integer a, Integer b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException("One of the two parameters is null");
		}

		return calculator.sum(a, b);
	}
}
