package ch.letterix.chatgpt.api;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestHandler implements RequestHandlerInterface{
    private static final String OPENAI_URL = "https://api.openai.com/v1/completions";

    private final String apiKey = "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";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public String handleHello(String prompt) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        int n = 3;
        String requestJson = "{\"prompt\":\"" + prompt + "\",\"n\":" + n + "}";

        HttpEntity<String> request = new HttpEntity<>(requestJson, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, request, String.class);
        return response.getBody();

    }
}
