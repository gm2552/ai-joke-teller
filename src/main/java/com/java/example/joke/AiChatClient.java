package com.java.example.joke;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiChatClient {

	
	private final ChatClient chatClient;

	@Autowired
	public AiChatClient(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	@GetMapping("/ai/joke")
	
	public Map<String, String> generation(
			@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) 
	
	{
		return Map.of("generation", chatClient.prompt().user(message).call().content());
	}	
}
