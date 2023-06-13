package ch.letterix.chatgpt.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RequestController {

    private final RequestHandlerInterface requestHandler;

    public RequestController(RequestHandlerInterface requestHandler) {
        this.requestHandler = requestHandler;
    }

    @GetMapping("/hello")
    public String hello() {
        return requestHandler.handleHello("Hello");
    }
}
