package ch.letterix.chatgpt.entities.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatCompletition {
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;


    public ChatCompletition() {}

    public ChatCompletition(String object, long created, String model, Choice[] choices, Usage usage) {
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }
}
