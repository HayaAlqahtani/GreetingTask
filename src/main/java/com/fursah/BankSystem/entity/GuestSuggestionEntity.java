package com.fursah.BankSystem.entity;

import com.fursah.BankSystem.util.enums.SuggestionStatus;

import javax.persistence.*;

@Entity
public class GuestSuggestionEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String rate;
    @Column(nullable = false)

    private String suggestionText;

    public SuggestionStatus getCreate() {
        return create;
    }

    public void setCreate(SuggestionStatus create) {
        this.create = create;
    }

    @Enumerated(EnumType.STRING)
    private SuggestionStatus create;

    public GuestSuggestionEntity(Long id, String rate, String suggestionText) {
        this.id = id;
        this.rate = rate;
        this.suggestionText = suggestionText;
    }

    public GuestSuggestionEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(Object suggestionText) {
        this.suggestionText = suggestionText;
    }
}
