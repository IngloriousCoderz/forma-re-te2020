package it.formarete.calculator.proxy;

import it.formarete.calculator.Calculator;

public class BaseCalculator implements Calculator {
	@Override
	public int sum(Integer a, Integer b) {
		return a + b;
	}
}
