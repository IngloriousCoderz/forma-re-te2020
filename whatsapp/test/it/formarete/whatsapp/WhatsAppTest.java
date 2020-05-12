package it.formarete.whatsapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class WhatsAppTest {

	@Test
	void test() {
		// given
		Server server = new Server();

		App alice = new App("Alice");
		App bob = new App("Bob");

		server.register(alice);
		server.register(bob);

		List<String> expectedMessages = List.of("[Alice]: Hello world!", "[Bob]: Hey, how are you?",
				"[Alice]: I'm good, thank you!");

		// when
		alice.send("Hello world!");
		bob.send("Hey, how are you?");
		alice.send("I'm good, thank you!");

		// then
		assertEquals(expectedMessages, server.getMessages());
		assertEquals(expectedMessages, alice.getMessages());
		assertEquals(expectedMessages, bob.getMessages());
	}

}
