package ch.letterix.chatgpt.api;

import ch.letterix.chatgpt.Entities.PromptObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final RequestHandlerInterface requestHandler;

    public RequestController(RequestHandlerInterface requestHandler) {
        this.requestHandler = requestHandler;
    }

    @PostMapping("/application")
    public String handleApplicationRequest(@RequestBody PromptObject promptObject) {
            return requestHandler.handleApplicationRequest(promptObject);
    }
}
