package ch.letterix.chatgpt.entities.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
    public Usage() {
    }

    public Usage(int prompt_tokens, int completion_tokens, int total_tokens) {
        this.prompt_tokens = prompt_tokens;
        this.completion_tokens = completion_tokens;
        this.total_tokens = total_tokens;
    }
}
