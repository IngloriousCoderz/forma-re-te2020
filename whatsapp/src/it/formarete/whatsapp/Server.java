package it.formarete.whatsapp;

import java.util.ArrayList;
import java.util.List;

public class Server {
	private List<String> messages;
	private List<App> apps;

	public Server() {
		messages = new ArrayList<>();
		apps = new ArrayList<>();
	}

	public List<String> getMessages() {
		return messages;
	}

	public void receive(String newMessage) {
		messages.add(newMessage);
		push(newMessage);
	}

	public void register(App app) {
		apps.add(app);
		app.setServer(this);
	}

	public void push(String newMessage) {
		for (App app : apps) {
			app.receive(newMessage);
		}
	}
}
