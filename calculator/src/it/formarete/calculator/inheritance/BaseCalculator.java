package it.formarete.calculator.inheritance;

import it.formarete.calculator.Calculator;

public class BaseCalculator implements Calculator {
	@Override
	public int sum(Integer a, Integer b) {
		return a + b;
	}
}
