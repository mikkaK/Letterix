package ch.letterix.letterix_backend.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String role;
    private String content;

public Message() {
    }

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
