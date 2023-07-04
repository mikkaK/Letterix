package ch.letterix.letterix_backend.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
    private Message message;
    private String finishReason;
    private int index;
    public Choice() {
    }

    public Choice(Message message, String finishReason, int index) {
        this.message = message;
        this.finishReason = finishReason;
        this.index = index;
    }
}
