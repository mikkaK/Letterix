package ch.letterix.letterix_backend.domain.storage_object;

import ch.letterix.letterix_backend.core.generic.AbstractEntity;
import ch.letterix.letterix_backend.domain.cover_letter.CoverLetter;
import ch.letterix.letterix_backend.entities.response.ChatCompletition;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class StorageObject extends AbstractEntity {
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cover_letter_id")
    private CoverLetter coverLetter;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "chat_completition_id")
    private ChatCompletition chatCompletition;



    public StorageObject() {
    }

    public StorageObject(UUID id, CoverLetter coverLetter, ChatCompletition chatCompletition) {
        super(id);
        this.coverLetter = coverLetter;
        this.chatCompletition = chatCompletition;
    }

    public ChatCompletition getChatCompletition() {
        return chatCompletition;
    }

    public void setChatCompletition(ChatCompletition chatCompletition) {
        this.chatCompletition = chatCompletition;
    }

    public CoverLetter getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(CoverLetter coverLetter) {
        this.coverLetter = coverLetter;
    }
}
