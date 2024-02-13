package com.fursah.BankSystem.service.suggestion;

import com.fursah.BankSystem.entity.GuestSuggestionEntity;
import com.fursah.BankSystem.reposatriy.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestSuggestionService {
    @Autowired
    private GuestSuggestionRepository suggestionRepository;
    public void processSuggestion(String suggestionText) {
        SuggestionProcessor suggestionProcessor = (text) -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(text);
            suggestionRepository.save(suggestionEntity);
        };

        suggestionProcessor.processSuggestion(suggestionText);
    }
}