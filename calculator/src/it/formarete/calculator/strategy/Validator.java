package it.formarete.calculator.strategy;

// !(a && b) = !a || !b
// !(a || b) = !a && !b

public class Validator {
	public boolean isValid(Integer a, Integer b) {
		return a != null && b != null;
	}
}
