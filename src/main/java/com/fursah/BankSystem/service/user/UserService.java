package com.fursah.BankSystem.service.user;

import com.fursah.BankSystem.bo.user.UpdateUserRequest;
import com.fursah.BankSystem.bo.user.CreateUserRequest;

import java.util.List;

public interface UserService {

    void saveUser(CreateUserRequest createUserRequest);

    void updateUserStaus(UpdateUserRequest updateUserRequest);

    List<String> getAllusersWithStrongPassword();

}
