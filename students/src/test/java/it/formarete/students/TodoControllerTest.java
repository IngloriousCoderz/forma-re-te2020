package it.formarete.students;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.formarete.students.model.Student;
import it.formarete.students.presentation.NotFoundException;
import it.formarete.students.presentation.StudentController;

@SpringBootTest
class StudentControllerTest {
	@Autowired
	private StudentController controller;

	@Test
	void shouldPerformCrudOperations() {
		shouldRetrieveAllStudents();
		shouldRetrieveById();
		shouldThrowIfNotFound();
		shouldAddStudent();
		shouldReplaceStudent();
		shouldMergeStudent();
		shouldRemoveStudent();
	}

	private void shouldRetrieveAllStudents() {
		List<Student> students = controller.all();
		assertThat(students.size(), is(3));
	}

	private void shouldRetrieveById() {
		Student student = controller.get(2);
		assertThat(student.getFirstName(), is("Antony"));
	}

	private void shouldThrowIfNotFound() {
		assertThrows(NotFoundException.class, () -> controller.get(4));
	}

	private void shouldAddStudent() {
		// given
		Student body = new Student();
		body.setFirstName("Giancarlo");
		body.setLastName("Magalli");

		// when
		controller.add(body);

		// then
		Student student = controller.get(4);
		assertThat(controller.all().size(), is(4));
		assertThat(student.getFirstName(), is("Giancarlo"));
		assertThat(student.getLastName(), is("Magalli"));
	}

	private void shouldReplaceStudent() {
		// given
		Student body = new Student();
		body.setFirstName("Pippo");
		body.setLastName("Baudo");

		// when
		controller.replace(2, body);

		// then
		Student student = controller.get(2);

		assertThat(student.getFirstName(), is(body.getFirstName()));
		assertThat(student.getLastName(), is(body.getLastName()));
	}

	private void shouldMergeStudent() {
		// given
		Student body = new Student();
		body.setLastName("Franco");

		// when
		controller.merge(2, body);

		// then
		Student student = controller.get(2);
		assertThat(student.getFirstName(), is("Pippo"));
		assertThat(student.getLastName(), is("Franco"));
	}

	private void shouldRemoveStudent() {
		controller.remove(2);
		List<Student> students = controller.all();
		assertThat(students.size(), is(3));
		assertThrows(NotFoundException.class, () -> controller.get(2));
	}
}
