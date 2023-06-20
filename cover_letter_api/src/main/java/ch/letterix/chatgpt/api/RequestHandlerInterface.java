package ch.letterix.chatgpt.api;

import ch.letterix.chatgpt.Entities.PromptObject;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Service;

@Service
public interface RequestHandlerInterface {

    public String handleApplicationRequest(PromptObject promptObject);
}
