package com.fursah.BankSystem.service.suggestion;

import com.fursah.BankSystem.entity.GuestSuggestionEntity;
import com.fursah.BankSystem.reposatriy.GuestSuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestSuggestionService implements SuggestionService {

    private final GuestSuggestionRepository suggestionRepository ;

    public GuestSuggestionService(GuestSuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    public List<GuestSuggestionEntity> findAllDataSuggestions() {
        List<GuestSuggestionEntity> allSuggestions = suggestionRepository.findAll();
        return allSuggestions.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> printAndProcessSuggestion(String suggestionText) {
        return suggestionRepository.findAll();

    }
    public List<GuestSuggestionEntity> findAllCreatedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.CREATE);
    }
    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.REMOVE);
    }

//    @Override
//    public void processSuggestion(CreateSuggestionRequest suggestionTex) {
//      SuggestionService processSuggestion = suggestionText -> {
//
//            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
//            suggestionEntity.setSuggestionText(suggestionTex.getSuggestionText());
//
//            suggestionRepository.save(suggestionEntity);
//        };
//    }


    public void processSuggestion(CreateSuggestionRequest suggestionTex) {
        ProcessSuggestion processSuggestion = suggest -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestionEntity.getSuggestionText());
            suggestionRepository.save(suggestionEntity);
        };
    }

    @Override
    public void getSuggestionRate() {


    }

    @Override
    public List<GuestSuggestionEntity> getCreateStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.CREATE))
                .collect(Collectors.toList());

    }

    @Override
    public List<GuestSuggestionEntity> getRemoveStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.REMOVE))
                .collect(Collectors.toList());

    }
}