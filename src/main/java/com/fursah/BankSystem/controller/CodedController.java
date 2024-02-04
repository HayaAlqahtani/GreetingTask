package com.fursah.BankSystem.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CodedController {
    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody Farewel requestBody) {
        String name = requestBody.getName();
        return "Goodbye, " + name + "!";
    }


}

