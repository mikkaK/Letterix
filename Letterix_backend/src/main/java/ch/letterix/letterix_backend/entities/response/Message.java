package ch.letterix.letterix_backend.entities.response;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
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
