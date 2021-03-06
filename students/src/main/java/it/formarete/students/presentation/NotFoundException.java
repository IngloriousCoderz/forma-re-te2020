package it.formarete.students.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Could not find the requested resource.")
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 5503242091966562657L;
}
