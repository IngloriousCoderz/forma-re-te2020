package it.formarete.calculator.strategy;

import it.formarete.calculator.Calculator;

public class CalculatorWith implements Calculator {
	private Validator validator;

	public CalculatorWith(Validator validator) {
		this.validator = validator;
	}

	@Override
	public int sum(Integer a, Integer b) {
		if (!validator.isValid(a, b)) {
			throw new IllegalArgumentException("One of the two parameters is null");
		}
		return a + b;
	}
}
