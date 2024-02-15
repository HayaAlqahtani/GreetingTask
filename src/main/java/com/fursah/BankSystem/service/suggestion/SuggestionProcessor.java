package com.fursah.BankSystem.service.suggestion;

import com.fursah.BankSystem.entity.GuestSuggestionEntity;

import java.util.List;


public interface SuggestionProcessor {
    void getSuggestionRate ();
    List<GuestSuggestionEntity> getCreateStatusSuggestions();
    List<GuestSuggestionEntity> getRemoveStatusSuggestions();
}
