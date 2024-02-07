package com.fursah.BankSystem.service.user;

import com.fursah.BankSystem.bo.user.UpdateUserRequest;
import com.fursah.BankSystem.service.user.UserService;
import com.fursah.BankSystem.util.enums.Status;
import com.fursah.BankSystem.entity.UserEntity;
import com.fursah.BankSystem.reposatriy.UserRepository;
import com.fursah.BankSystem.bo.user.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest){

        UserEntity userEntity=new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);
    }

    @Override
   public void updateUserStaus(UpdateUserRequest updateUserRequest){
        UserEntity userEntity=userRepository.findById(updateUserRequest.getUserId()).orElseThrow();
        if (!updateUserRequest.getStatus().equals("ACTIVE")|| !updateUserRequest.getStatus().equals("INACTIVE")){
            throw new IllegalArgumentException("The Status Should be Active Or Inactive");
        }
        userEntity.setStatus(Status.valueOf(updateUserRequest.getStatus()));
        userRepository.save(userEntity);
    }
}
