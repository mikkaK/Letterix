package ch.letterix.chatgpt.api;

import ch.letterix.chatgpt.entities.PromptObject.PromptObject;
import ch.letterix.chatgpt.entities.response.ChatCompletition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;

@Service
@Log4j2
public class RequestHandler implements RequestHandlerInterface{
    private static final String OPENAI_URL = "https://api.openai.com/v1/chat/completions";
    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${letterix.OPENAI_API_KEY}")
    private String OPENAI_API_KEY;

    @Override
    public ChatCompletition handleApplicationRequest(PromptObject promptObject) throws JsonProcessingException {
        log.info("Starting request to OpenAI API");


        String prompt = buildPrompt(promptObject);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        if (!Objects.equals(OPENAI_API_KEY, "notFound") || !Objects.equals(OPENAI_API_KEY, "")){
            log.info("API Key found");
            log.info("API Key: " + OPENAI_API_KEY);
        } else {
            log.error("API Key not found");
        }

        headers.set("Authorization", "Bearer " + OPENAI_API_KEY);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        String requestJson = "{\"model\":\"gpt-3.5-turbo\",\"messages\":[{\"role\":\"user\",\"content\":\""+ /*prompt*/ "test" +"\"}]}";

        HttpEntity<?> request = new HttpEntity<>(requestJson, headers);

        log.info("Request: " + requestJson);

        ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_URL, request, String.class);
        log.info("Response: " + response.getBody() );

        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(response.getBody(), ChatCompletition.class);

    }


}
