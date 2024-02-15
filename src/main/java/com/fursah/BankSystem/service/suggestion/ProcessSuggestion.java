package com.fursah.BankSystem.service.suggestion;

import com.fursah.BankSystem.bo.suggestionRequest.CreateSuggestionRequest;

public interface ProcessSuggestion {
    void processSuggestion(CreateSuggestionRequest suggestionTex);
}