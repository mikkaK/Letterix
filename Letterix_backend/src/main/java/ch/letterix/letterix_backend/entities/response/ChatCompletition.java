package ch.letterix.letterix_backend.entities.response;


import ch.letterix.letterix_backend.core.generic.AbstractEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class ChatCompletition extends AbstractEntity{
    private String object;
    private long created;
    private String model;
    private Usage usage;
    private List<Choice> choices;

    public ChatCompletition() {}

    public ChatCompletition(UUID id, String object, long created, String model, Usage usage, List<Choice> choices) {
        super(id);
        this.object = object;
        this.created = created;
        this.model = model;
        this.usage = usage;
        this.choices = choices;
    }
}
