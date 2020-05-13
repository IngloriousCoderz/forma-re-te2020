package it.formarete.whatsapp;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<App> apps;
	private List<String> messages;

	public Server() {
		apps = new ArrayList<>();
		messages = new ArrayList<>();
	}

	public void register(App app) {
		apps.add(app);
		app.setServer(this);
	}

	public void receive(String message) {
		messages.add(message);
		push(message);
	}

	public void push(String message) {
		for (App app : apps) {
			app.receive(message);
		}
	}

	public List<String> getMessages() {
		return messages;
	}
}
