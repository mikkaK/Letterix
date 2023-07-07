package ch.letterix.coverletterservice.domain.response.entity;


import ch.letterix.coverletterservice.core.generic.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "chat_completion")
public class ChatCompletion extends AbstractEntity {
    private String object;
    private long created;
    private String model;
    private Choice[] choices;
    private Usage usage;


    public ChatCompletion() {}

    public ChatCompletion(String object, long created, String model, Choice[] choices, Usage usage) {
        this.object = object;
        this.created = created;
        this.model = model;
        this.choices = choices;
        this.usage = usage;
    }
}
