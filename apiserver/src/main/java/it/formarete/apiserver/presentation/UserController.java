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
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository users;
	@Autowired
	private TodoRepository todos;

	@GetMapping
	public List<User> all() {
		return users.findAll();
	}

	@GetMapping("/{id}")
	public User get(@PathVariable int id) {
		User user = users.findById(id);
		if (user == null) {
			throw new NotFoundException();
		}
		return user;
	}

	@GetMapping("/{id}/todos")
	public List<Todo> getTodos(@PathVariable int id) {
		User user = get(id);
		return todos.findByAuthor(user);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User add(@RequestBody User body) {
		return users.save(body);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void replace(@PathVariable int id, @RequestBody User body) {
		User user = get(id);
		body.setId(user.getId());
		users.save(body);
	}

	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void merge(@PathVariable int id, @RequestBody User body) {
		User user = get(id);
		String firstName = body.getUsername();
		if (firstName != null) {
			user.setUsername(firstName);
		}
		String lastName = body.getPassword();
		if (lastName != null) {
			user.setPassword(lastName);
		}
		users.save(user);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remove(@PathVariable int id) {
		User user = get(id);
		users.delete(user);
	}
}
