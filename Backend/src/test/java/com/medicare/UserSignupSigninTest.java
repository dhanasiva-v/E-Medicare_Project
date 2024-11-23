package com.medicare;

import jakarta.transaction.Transactional;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicare.user.AuthenticationStatus;
import com.medicare.user.User;
import com.medicare.user.UserRepository;
import com.medicare.user.UserService;


@RunWith(Suite.class)
@SuiteClasses({})
@SpringBootTest
class UserSignupSigninTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	
//	@Test
//	@DisplayName("SigUp with valid details")
//	public void signUpTest(){
//		User user = new User();
//		user.setFirst_name("First");
//		user.setLast_name("UserTest");
//		user.setMobile_no("9876543210");
//		user.setAge(25);
//		user.setUsername("firstusertest@email.com");
//		user.setPassword("Password@123");
//		user.setGender("Male");
//		
//		userService.insertUser(user);
//	}
	
	@Test
	@Transactional
	public void signUpTest() {
	    String uniqueEmail = "firstusertest" + System.currentTimeMillis() + "@email.com";
	    User user = new User();
	    user.setEmail(uniqueEmail);
	    user.setPassword("password");
	    // set other user properties

	    userService.insertUser(user);

	    // Add assertions to verify the user was saved
	}

	
	@Test
	@DisplayName("SigIn with valid details")
	public void signInTest(){
		String username = "firstusertest@email.com";
		String password = "Password@123";
		
		AuthenticationStatus res = userService.getStatus(username, password);
	}

}
