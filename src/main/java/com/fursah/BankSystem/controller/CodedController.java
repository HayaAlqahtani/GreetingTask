package com.fursah.BankSystem.controller;

import com.fursah.BankSystem.entity.UserEntity;
import com.fursah.BankSystem.service.UserService;
import com.fursah.BankSystem.bo.Contact;
import com.fursah.BankSystem.bo.Farewel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CodedController {
    private List<Contact> contacts = new ArrayList<>();

    @GetMapping("/greet")
    public String greet(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody Farewel requestBody) {
        String name = requestBody.getName();
        return "Goodbye, " + name + "!";
    }


    @PostMapping("/addContact")
    public String addContact(@RequestBody Contact contact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getEmail().equalsIgnoreCase(contact.getEmail())) {
                return "Contact already exists with this email!";
            }
        }
        contacts.add(contact);
        return "Contact added: " + contact.getName();
    }


    @GetMapping("/getContactDetails")
    public String getContactDetails(@RequestParam String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return "Contact details: Name - " + contact.getName() +
                        ", Email - " + contact.getEmail() +
                        ", Phone - " + contact.getPhone();
            }
        }
        return "Contact not found.";
    }
}






