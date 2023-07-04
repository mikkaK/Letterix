package ch.letterix.chatgpt.entities.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatCompletition {
    private String object;
    private long created;
    private String model;
    private Usage usage;
    private Choice[] choices;

    public ChatCompletition() {}
    public ChatCompletition( String object, long created, String model, Usage usage, Choice[] choices) {
        this.object = object;
        this.created = created;
        this.model = model;
        this.usage = usage;
        this.choices = choices;
    }
}
