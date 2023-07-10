package ch.letterix.chatgpt.entities.PromptObject;

import java.util.List;

public class PromptObject {

    private String name;
    private String surname;
    private String age;
    private String appliedCompany;
    private String position;
    private String currentEducationLevel;
    private List<String> skills;
    private List<String> interests;
    private List<String> weaknesses;

    public PromptObject(String name, String surname, String age, String appliedCompany, String position, String currentEducationLevel, List<String> skills, List<String> interests, List<String> weaknesses) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAppliedCompany() {
        return appliedCompany;
    }

    public void setAppliedCompany(String appliedCompany) {
        this.appliedCompany = appliedCompany;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCurrentEducationLevel() {
        return currentEducationLevel;
    }

    public void setCurrentEducationLevel(String currentEducationLevel) {
        this.currentEducationLevel = currentEducationLevel;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<String> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<String> weaknesses) {
        this.weaknesses = weaknesses;
    }
}
