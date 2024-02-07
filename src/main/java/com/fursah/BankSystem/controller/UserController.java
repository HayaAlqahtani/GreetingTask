package com.fursah.BankSystem.controller;

import com.fursah.BankSystem.bo.user.CreateUserRequest;
import com.fursah.BankSystem.bo.user.UpdateUserRequest;
import com.fursah.BankSystem.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {this.userService = userService;}

    @PostMapping("create-user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.saveUser(createUserRequest);
        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body("bad");
        }
        userService.saveUser(createUserRequest);
        return ResponseEntity.ok("user created");
    }
    @PutMapping("update-user-status")
    public ResponseEntity<String >updateuser(UpdateUserRequest updateUserRequest){
        try {
            userService.updateUserStaus(updateUserRequest);

        }catch (IllegalArgumentException e){

            return ResponseEntity.badRequest().body("bad");

        }
        return ResponseEntity.ok("user created");

    }
}