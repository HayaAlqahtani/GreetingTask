package com.fursah.BankSystem.reposatriy;

import com.fursah.BankSystem.entity.GuestSuggestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity,Long> {
      default Object save(GuestSuggestionEntity suggestionEntity) {

          return null;
      }
}
