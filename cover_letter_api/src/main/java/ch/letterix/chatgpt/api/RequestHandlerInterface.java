package ch.letterix.chatgpt.api;

import ch.letterix.chatgpt.entities.PromptObject.PromptObject;
import ch.letterix.chatgpt.entities.response.ChatCompletition;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public interface RequestHandlerInterface {

    public ChatCompletition handleApplicationRequest(PromptObject promptObject) throws JsonProcessingException;
}
