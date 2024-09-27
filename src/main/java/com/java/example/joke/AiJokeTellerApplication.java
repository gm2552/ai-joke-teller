package com.java.example.joke;

import org.springframework.ai.autoconfigure.openai.OpenAiAutoConfiguration;
import org.springframework.ai.autoconfigure.vertexai.gemini.VertexAiGeminiAutoConfiguration;
import org.springframework.ai.autoconfigure.vertexai.gemini.VertexAiGeminiConnectionProperties;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.google.auth.ApiKeyCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.vertexai.VertexAI;

@SpringBootApplication(
	    exclude = {
	      //OpenAiAutoConfiguration.class,
	      VertexAiGeminiAutoConfiguration.class
	    })
public class AiJokeTellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiJokeTellerApplication.class, args);
	}
	
    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder.build();
    }

    /*
    @Bean
    VertexAI vertexAPI(VertexAiGeminiConnectionProperties connectionProperties)
    {
		var vertexAIBuilder = new VertexAI.Builder().setProjectId(connectionProperties.getProjectId())
				.setLocation(connectionProperties.getLocation())
				.setTransport(com.google.cloud.vertexai.Transport.valueOf(connectionProperties.getTransport().name()));

			if (StringUtils.hasText(connectionProperties.getApiEndpoint())) {
				vertexAIBuilder.setApiEndpoint(connectionProperties.getApiEndpoint());
			}
			if (!CollectionUtils.isEmpty(connectionProperties.getScopes())) {
				vertexAIBuilder.setScopes(connectionProperties.getScopes());
			}

			ApiKeyCredentials apiKey = ApiKeyCredentials.create("AIzaSyDYH02S-56oOSpO7QVcKoLtx8koIj1SsBQ");
			
			vertexAIBuilder.setCredentials(apiKey);
			
			
			return vertexAIBuilder.build();
    }
    
    */
}
