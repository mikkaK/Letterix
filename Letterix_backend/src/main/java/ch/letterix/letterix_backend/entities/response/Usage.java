package ch.letterix.letterix_backend.entities.response;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Usage {
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;
    public Usage() {
    }

    public Usage(int promptTokens, int completionTokens, int totalTokens) {
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
    }
}
