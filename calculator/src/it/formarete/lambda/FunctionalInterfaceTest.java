package it.formarete.lambda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FunctionalInterfaceTest {

	@Test
	void testAnonymousInterface() {
		FunctionalInterface fi = new FunctionalInterface() {
			@Override
			public int square(int x) {
				return x * x;
			}
		};

		assertEquals(4, fi.square(2));
	}

	@Test
	void testLambda() {
		FunctionalInterface lambda = (int x) -> x * x;
		assertEquals(4, lambda.square(2));
	}
}
