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
import it.formarete.apiserver.model.User;
import it.formarete.apiserver.services.TodoRepository;
import it.formarete.apiserver.services.UserRepository;

@RestController
@RequestMapping("/todos")
public class TodosController {
	@Autowired
	private TodoRepository todos;
	@Autowired
	private UserRepository users;

	@GetMapping
	public List<Todo> all() {
		return todos.findAll();
	}

	@GetMapping("/{id}")
	public Todo get(@PathVariable int id) {
		Todo todo = todos.findById(id);
		if (todo == null) {
			throw new NotFoundException();
		}
		return todo;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Todo add(@RequestBody Todo body) {
		User author = body.getAuthor();
		if (author != null) {
			Integer id = author.getId();
			String username = author.getUsername();
			if (id != null) {
				body.setAuthor(users.findById((int) id));
			} else if (username != null) {
				body.setAuthor(users.findByUsername(username));
			}
		}
		return todos.save(body);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void replace(@PathVariable int id, @RequestBody Todo body) {
		Todo todo = get(id);
		body.setId(todo.getId());
		todos.save(body);
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
		todos.save(todo);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable int id) {
		Todo todo = get(id);
		todos.delete(todo);
	}
}
