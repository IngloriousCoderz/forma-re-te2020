package it.formarete.calculator.proxy;

import it.formarete.calculator.Calculator;

public class LoggingProxy implements Calculator {
	private Calculator calculator;

	public LoggingProxy(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public int sum(Integer a, Integer b) {
		// before
		System.out.println("Input: " + a + ", " + b);
		// chain
		int sum = calculator.sum(a, b);
		// after
		System.out.println("Output: " + sum);
		return sum;
	}
}
