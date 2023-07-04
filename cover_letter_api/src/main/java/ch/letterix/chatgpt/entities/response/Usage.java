package ch.letterix.chatgpt.entities.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
