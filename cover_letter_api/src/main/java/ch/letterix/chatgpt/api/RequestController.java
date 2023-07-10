package ch.letterix.chatgpt.api;

import ch.letterix.chatgpt.entities.PromptObject.PromptObject;
import ch.letterix.chatgpt.entities.response.ChatCompletition;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final RequestHandlerInterface requestHandler;

    public RequestController(RequestHandlerInterface requestHandler) {
        this.requestHandler = requestHandler;
    }

    @PostMapping("/application")
    public ResponseEntity<ChatCompletition> handleApplicationRequest(@RequestBody PromptObject promptObject) throws JsonProcessingException {
            return new ResponseEntity<>(requestHandler.handleApplicationRequest(promptObject), HttpStatus.OK);
    }
}
