package it.formarete.tdd.triangle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangleTest {

	@Test
	void testEvenRows() {
		// given
		Triangle triangle = new Triangle(4);
		
		// when
		String result = triangle.render();
		
		// then
		assertEquals(
				"   #\n"+
				"  ###\n" +
				" #####\n" +
				"#######\n", result);
	}
	
	@Test
	void testOddRows() {
		// given
		Triangle triangle = new Triangle(5);
		
		// when
		String result = triangle.render();
		
		// then
		assertEquals(
				"    #\n"+
				"   ###\n" +
				"  #####\n" +
				" #######\n" +
				"#########\n", result);
	}
	
	@Test
	void testOneRow() {
		// given
		Triangle triangle = new Triangle(1);
		
		// when
		String result = triangle.render();
		
		// then
		assertEquals("#\n", result);
	}
}
