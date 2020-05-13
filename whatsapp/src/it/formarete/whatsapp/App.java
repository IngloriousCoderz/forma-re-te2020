package it.formarete.whatsapp;

import java.util.ArrayList;
import java.util.List;

public class App {
	private String sender;
	private List<String> messages;
	private Server server;

	public App(String sender) {
		this.sender = sender;
		messages = new ArrayList<>();
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void send(String message) {
		server.receive("[" + sender + "]: " + message);
	}

	public void receive(String message) {
		messages.add(message);
	}

	public List<String> getMessages() {
		return messages;
	}
}
