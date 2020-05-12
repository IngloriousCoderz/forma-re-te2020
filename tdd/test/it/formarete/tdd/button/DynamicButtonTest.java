package it.formarete.tdd.button;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DynamicButtonTest {

	@Test
	void testDefault() {
		// given
		DynamicButton button = new DynamicButton(10, 10);
		
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
		DynamicButton button = new DynamicButton(10, 10);
		
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
		DynamicButton button = new DynamicButton(7, 10);
		
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
		DynamicButton button = new DynamicButton(10, 7);
		
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
		DynamicButton button = new DynamicButton(10, 10);
		
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
	
	@Test
	void testOtherSymbols() {
		// given
		DynamicButton button = new DynamicButton(10, 10, "+", "-", "|", " ");
		
		// when
		String result = button.render("ciao");
		
		// then
		assertEquals("+--------+\n" + 
				"|        |\n" + 
				"|        |\n" +
				"|        |\n" +
				"|        |\n" +
				"|  ciao  |\n" +
				"|        |\n" + 
				"|        |\n" +
				"|        |\n" +
				"|        |\n" +
				"+--------+\n", result);
	}
}
