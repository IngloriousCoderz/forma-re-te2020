package it.formarete.tdd.button;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Overloading
 * 
 * +----------+
 * |          |
 * |   ciao   |
 * |          |
 * +----------+
 */

class ButtonTest {

	@Test
	void testDefault() {
		// given
		Button button = new Button(10, 10);
		
		// when
		String result = button.render("ciao");
		
		// then
		assertEquals("* * * * * * * * * * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*       ciao      * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"* * * * * * * * * * \n", result);
	}

	@Test
	void testOddText() {
		// given
		Button button = new Button(10, 10);
		
		// when
		String result = button.render("ciauz");
		
		// then
		assertEquals("* * * * * * * * * * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*      ciauz      * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"* * * * * * * * * * \n", result);
	}
	
	@Test
	void testOddRows() {
		// given
		Button button = new Button(7, 10);
		
		// when
		String result = button.render("ciao");
		
		// then
		assertEquals("* * * * * * * * * * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*       ciao      * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"* * * * * * * * * * \n", result);
	}
	
	@Test
	void testOddColumns() {
		// given
		Button button = new Button(10, 7);
		
		// when
		String result = button.render("ciao");
		
		// then
		assertEquals("* * * * * * * \n" + 
				"*           * \n" + 
				"*           * \n" + 
				"*           * \n" + 
				"*           * \n" + 
				"*    ciao   * \n" + 
				"*           * \n" + 
				"*           * \n" + 
				"*           * \n" + 
				"*           * \n" + 
				"* * * * * * * \n", result);
	}
	
	@Test
	void testLongText() {
		// given
		Button button = new Button(10, 10);
		
		// when
		String result = button.render("bella ciao");
		
		// then
		assertEquals("* * * * * * * * * * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*    bella ciao   * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"*                 * \n" + 
				"* * * * * * * * * * \n", result);
	}
}
