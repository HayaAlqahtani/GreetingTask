package com.fursah.BankSystem.controller;

import com.fursah.BankSystem.bo.suggestionRequest.CreateSuggestionRequest;
import com.fursah.BankSystem.service.suggestion.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/suggestions")
public class SuggestionController {
    @Autowired
    private GuestSuggestionService suggestionService;

    @PostMapping
    public ResponseEntity<String>handleSuggestions(@RequestBody CreateSuggestionRequest request){
        suggestionService.processSuggestion(request.getSuggestionText());
        return ResponseEntity.ok("suggestion processed ");
    }

}
