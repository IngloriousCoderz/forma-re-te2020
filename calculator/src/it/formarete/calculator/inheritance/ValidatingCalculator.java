package it.formarete.calculator.inheritance;

public class ValidatingCalculator extends BaseCalculator {
	@Override
	public int sum(Integer a, Integer b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException("One of the two parameters is null");
		}

		return super.sum(a, b);
	}
}
