package ch.letterix.chatgpt.Entities.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatCompletition {
    private String id;
    private String object;
    private long created;
    private String model;
    private Usage usage;
    private Choice[] choices;

    public ChatCompletition() {}
    public ChatCompletition(String id, String object, long created, String model, Usage usage, Choice[] choices) {
        this.id = id;
        this.object = object;
        this.created = created;
        this.model = model;
        this.usage = usage;
        this.choices = choices;
    }
}
