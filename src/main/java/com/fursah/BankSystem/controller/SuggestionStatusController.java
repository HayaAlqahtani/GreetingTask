package com.fursah.BankSystem.controller;

import com.fursah.BankSystem.util.enums.SuggestionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SuggestionStatusController {
    @GetMapping("/create")
    public String create(RequestParam SuggestionStatus) {
        return create();
    }

    private String create() {
        return null;
    }

    @GetMapping("/remove")
    public String remove(@RequestParam SuggestionStatus) {
        return remove();
    }

}
