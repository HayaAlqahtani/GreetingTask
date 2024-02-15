package com.fursah.BankSystem.reposatriy;

import com.fursah.BankSystem.entity.GuestSuggestionEntity;
import com.fursah.BankSystem.util.enums.SuggestionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity,Long> {
    List<GuestSuggestionEntity> findBySuggestionsStatus(SuggestionStatus status);

}