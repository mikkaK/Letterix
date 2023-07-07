package ch.letterix.coverletterservice.domain.cover_letter;

import ch.letterix.coverletterservice.core.generic.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "cover_letter")
public class CoverLetter extends AbstractEntity {

    private String name;
    private String surname;
    private String age;
    private String appliedCompany;
    private String position;
    private String currentEducationLevel;
    private List<String> skills;
    private List<String> interests;
    private List<String> weaknesses;

    public CoverLetter() {
    }

    public CoverLetter(UUID id, String name, String surname, String age, String appliedCompany, String position, String currentEducationLevel, List<String> skills, List<String> interests, List<String> weaknesses) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.appliedCompany = appliedCompany;
        this.position = position;
        this.currentEducationLevel = currentEducationLevel;
        this.skills = skills;
        this.interests = interests;
        this.weaknesses = weaknesses;
    }
}
