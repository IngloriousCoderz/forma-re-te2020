package it.formarete.whatsapp;

import java.util.ArrayList;
import java.util.List;

public class App {
	private String sender;
	public List<String> messages;
	private Server server;

	public App(String sender) {
		this.sender = sender;
		messages = new ArrayList<>();
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void send(String message) {
		server.receive("[" + sender + "]: " + message);
	}

	public void receive(String newMessage) {
		messages.add(newMessage);
	}
}
