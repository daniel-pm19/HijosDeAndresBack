package edu.hackaton.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import jakarta.ws.rs.core.HttpHeaders;

@Service
public class AiService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.openai.com/v1/responses")
            .build();

    public String analyzeImage(String imageUrl) {
        // Pedimos una descripción breve de la imagen
        String body = """
        {
          "model": "gpt-4.1-mini",
          "input": [
            {"role": "user", "content": [
              {"type": "input_text", "text": "Describe brevemente la siguiente imagen:"},
              {"type": "input_image", "image_url": "%s"}
            ]}
          ]
        }
        """.formatted(imageUrl);

        String responseJson = webClient.post()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(responseJson);
        return responseJson;
    }
}

