package it.formarete.apiserver.presentation;

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

import it.formarete.apiserver.model.Todo;
import it.formarete.apiserver.services.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodosController {
	@Autowired
	private TodoRepository db;

	@GetMapping
	public List<Todo> all() {
		return db.findAll();
	}

	@GetMapping("/{id}")
	public Todo get(@PathVariable int id) {
		Todo todo = db.findById(id);
		if (todo == null) {
			throw new NotFoundException();
		}
		return todo;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Todo add(@RequestBody Todo body) {
		return db.save(body);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void replace(@PathVariable int id, @RequestBody Todo body) {
		Todo todo = get(id);
		body.setId(todo.getId());
		db.save(body);
	}

	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void merge(@PathVariable int id, @RequestBody Todo body) {
		Todo todo = get(id);
		String text = body.getText();
		if (text != null) {
			todo.setText(text);
		}
		Boolean done = body.getDone();
		if (done != null) {
			todo.setDone(done);
		}
		db.save(todo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable int id) {
		Todo todo = get(id);
		db.delete(todo);
	}
}
