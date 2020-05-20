package it.formarete.maven;

import lombok.Data;

@Data
public class Todo {
	private Integer id;
	private String text;
	private Boolean done;
}
