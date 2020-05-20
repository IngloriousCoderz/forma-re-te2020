package it.formarete.students.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.formarete.students.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	List<Student> findAll();

	Student findById(int id);
}
