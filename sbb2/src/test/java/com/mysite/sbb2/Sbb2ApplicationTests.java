package com.mysite.sbb2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb2.users.UserRepository;
import com.mysite.sbb2.users.Users;

@SpringBootTest
class Sbb2ApplicationTests {
	@Autowired
	UserRepository userrepository;
	
	@Test
	public void insert1000() {
		Users u = null;
		
		for(int i = 1; i <=1000; i++) {
			u = new Users();
			u.setName("이름-" + i);
			u.setPass("pass1");
			u.setEmail("메일주소"+ i);
			u.setCreateDate(LocalDateTime.now());
			u.setCnt(i);
			
			this.userrepository.save(u);
		}
	}
	
	
	
	/*
	//값 삭제 
	@Test
	void delete() {
		Optional<Users> us = this.userrepository.findById(4);
		Users u =us.get();
		this.userrepository.delete(u);
	}
	
	
	//값 수정 
	@Test
	void update() {
		Optional<Users> us = this.userrepository.findById(3);
		Users u =us.get();
		u.setName("송강호");
		u.setEmail("늙은이이메일");
		this.userrepository.save(u);
	}
	
	@Test
	void update2() {
		Optional<Users> us = this.userrepository.findById(5);
		Users u =us.get();
		u.setName("송중기");
		u.setEmail("이혼후5개월재혼남");
		this.userrepository.save(u);
	}
	
	
	@Test
	//값을 조회 
	public void testuser() {
		List<Users> all =
				this.userrepository.findAllByOrderByCreateDateDesc();
		
		System.out.println("내림차순 정렬");
		for(int i = 0; i < all.size(); i++) {
			Users u = all.get(i);
			
			System.out.println(u.getIdx());
			System.out.println(u.getName());
			System.out.println(u.getPass());
			System.out.println(u.getEmail());
			System.out.println("==날짜기준 정렬==");
		}
				
	}
	
	
	//값 넣기 
	/*@Test
	void contextLoads() {
		Users u1 = new Users();
		
		u1.setName("송강");
		u1.setPass("1234");
		u1.setEmail("pratt33@네이버");
		u1.setCreateDate(LocalDateTime.now());
		
		this.userrepository.save(u1);
		
		
	}
	 */
}
