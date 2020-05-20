package it.formarete.students.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.formarete.students.model.Student;
import it.formarete.students.service.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentRepository db;

	@GetMapping
	public List<Student> all() {
		return db.findAll();
	}

	@GetMapping("/{id}")
	public Student get(@PathVariable int id) {
		Student student = db.findById(id);
		if (student == null) {
			throw new NotFoundException();
		}
		return student;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student add(@RequestBody Student body) {
		return db.save(body);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void replace(@PathVariable int id, @RequestBody Student body) {
		Student student = get(id);
		body.setId(student.getId());
		db.save(body);
	}

	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void merge(@PathVariable int id, @RequestBody Student body) {
		Student student = get(id);
		String firstName = body.getFirstName();
		if (firstName != null) {
			student.setFirstName(firstName);
		}
		String lastName = body.getLastName();
		if (lastName != null) {
			student.setLastName(lastName);
		}
		db.save(student);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable int id) {
		Student student = get(id);
		db.delete(student);
	}
}
