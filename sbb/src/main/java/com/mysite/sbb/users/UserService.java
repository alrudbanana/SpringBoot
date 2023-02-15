package com.mysite.sbb.users;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	//securityConfig 에 생성한 Bean을 주입 
	private final PasswordEncoder passwordEncoder;
	
	private final UserRepository userRepository;
	
	 public SiteUser create(String username, String email, String password) {
	 SiteUser user = new SiteUser();
	 user.setUsername(username);
	 user.setEmail(email);
	 user.setPassword(passwordEncoder.encode(password));
	 this.userRepository.save(user);
	 return user;
	 }
	}

