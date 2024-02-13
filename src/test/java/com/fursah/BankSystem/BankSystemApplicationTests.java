package com.fursah.BankSystem;

import com.fursah.BankSystem.entity.GuestSuggestionEntity;
import com.fursah.BankSystem.entity.UserEntity;
import com.fursah.BankSystem.reposatriy.GuestSuggestionRepository;
import com.fursah.BankSystem.reposatriy.UserRepository;
import com.fursah.BankSystem.service.suggestion.GuestSuggestionService;
import com.fursah.BankSystem.service.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
class BankSystemApplicationTests {
	@MockBean
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@Test
	public void whenUserPasswordIsLargerThan8Digit_thenSuccess() {

		UserEntity userEntity1 = new UserEntity();
		userEntity1.setName("Thaer");
		userEntity1.setPassword("1234567891011");

		UserEntity userEntity2 = new UserEntity();
		userEntity2.setName("Haya");
		userEntity1.setPassword("1234987654");

		UserEntity userEntity3 = new UserEntity();
		userEntity3.setName("Awdah");
		userEntity1.setPassword("5678");

		List<UserEntity> moksUserEntities = Arrays.asList(userEntity1, userEntity2, userEntity3);
		Mockito.when(userRepository.findAll()).thenReturn(moksUserEntities);

		//ACT
		List<String> usersWithStrongPasswords = userService.getAllusersWithStrongPassword();
		//ASSERT
		List<String> expectedUserWithStrongPassword = Arrays.asList("Thaer", "Haya");
		assertEquals(expectedUserWithStrongPassword, usersWithStrongPasswords);


	}
}
