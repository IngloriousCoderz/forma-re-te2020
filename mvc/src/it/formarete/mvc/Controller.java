package it.formarete.mvc;

public class Controller {
	private Model model;

	public void setModel(Model model) {
		this.model = model;
	}

	public void handleInput(String input) {
		model.setAttribute(input);
	}
}
