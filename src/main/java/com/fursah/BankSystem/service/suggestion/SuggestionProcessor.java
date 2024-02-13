package com.fursah.BankSystem.service.suggestion;

import com.fursah.BankSystem.entity.UserEntity;

import java.util.List;


public interface SuggestionProcessor {
    void processSuggestion(String suggestionText);
    List<UserEntity> findAllCreatedSuggestions();

}
