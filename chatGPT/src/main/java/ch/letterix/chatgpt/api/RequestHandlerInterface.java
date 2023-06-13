package ch.letterix.chatgpt.api;

import org.springframework.stereotype.Service;

@Service
public interface RequestHandlerInterface {

    public String handleHello(String prompt);
}
