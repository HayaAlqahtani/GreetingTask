package com.fursah.BankSystem.controller;

import com.fursah.BankSystem.bo.suggestionRequest.CreateSuggestionRequest;
import com.fursah.BankSystem.entity.GuestSuggestionEntity;
import com.fursah.BankSystem.service.suggestion.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private final GuestSuggestionService suggestionService;

    @Autowired
    public SuggestionController(GuestSuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/suggest")
    public ResponseEntity<List<GuestSuggestionEntity>> handleSuggestions(@RequestBody CreateSuggestionRequest suggestionRequest) {
        List<GuestSuggestionEntity> suggestionList = suggestionService.printAndProcessSuggestion(suggestionRequest.getSuggestionText());
        return ResponseEntity.ok(suggestionList);
    }

    @PostMapping("/create-suggestion")
    public ResponseEntity<String> processSuggestion(CreateSuggestionRequest suggestionText) {
        suggestionService.processSuggestion(suggestionText);
        return ResponseEntity.ok("you created a suggestion");
    }
}