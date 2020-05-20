package it.formarete.apiserver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import it.formarete.apiserver.presentation.HelloController;

@SpringBootTest
class HelloControllerTest {
	@Autowired
	private HelloController controller;

	@Test
	void test() {
		// given
		Model model = new ExtendedModelMap();
		
		// when
		String result = controller.hello("forma-re-te", model);
		
		// then
		assertThat(result, is("hello"));
		assertThat(model.getAttribute("name"), is("forma-re-te"));
	}

}
