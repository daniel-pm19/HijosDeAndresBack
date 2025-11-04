package edu.hackaton.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AiService {

    private final WebClient webClient;

    public AiService(@Value("${openai.api.key}") String apiKey, WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.openai.com/v1")
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }

    public String analyzeImage(String imageUrl) {
        String body = """
        {
          "model": "gpt-4o-mini",
          "messages": [
            {
              "role": "user",
              "content": [
                {"type": "text", "text": "Describe brevemente la siguiente imagen:"},
                {"type": "image_url", "image_url": {"url": "%s"}}
              ]
            }
          ]
        }
        """.formatted(imageUrl);

        String responseJson = webClient.post()
                .uri("/chat/completions")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(responseJson);
        return responseJson;
    }
}
