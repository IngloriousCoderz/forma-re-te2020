package it.formarete.apiserver.presentation;

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
import it.formarete.apiserver.services.TodosRepository;

@RestController
@RequestMapping("/todos")
public class TodosController {
	@Autowired
	private TodosRepository db;

	@GetMapping
	public Iterable<Todo> all() {
		return db.findAll();
	}

	@GetMapping("/{id}")
	public Todo get(@PathVariable("id") int id) {
		Todo todo = db.findById(id);
		if (todo == null) {
			throw new NotFoundException();
		}
		return todo;
	}

	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Todo add(@RequestBody Todo body) {
		return db.save(body);
	}

	@PatchMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable("id") int id, @RequestBody Todo body) {
		Todo todo = get(id);
		String text = body.getText();
		if (text != null) {
			todo.setText(text);
		}
		Boolean done = body.isDone();
		if (done != null) {
			todo.setDone(done);
		}
		db.save(todo);
	}

	@PutMapping(path = "/{id}", consumes = "application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void replace(@PathVariable("id") int id, @RequestBody Todo body) {
		Todo todo = get(id);
		body.setId(todo.getId());
		db.save(body);
	}

	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable("id") int id) {
		Todo todo = get(id);
		db.delete(todo);
	}
}
