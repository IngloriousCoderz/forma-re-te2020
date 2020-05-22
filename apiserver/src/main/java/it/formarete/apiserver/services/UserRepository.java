package it.formarete.apiserver.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.formarete.apiserver.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	List<User> findAll();

	User findById(int id);

	User findByUsername(String username);
}
