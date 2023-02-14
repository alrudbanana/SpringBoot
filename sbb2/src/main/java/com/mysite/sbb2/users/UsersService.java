package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mysite.sbb2.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

	
	private final UserRepository userRepository;
	
	public Page<Users> getList(int page){

		List<Sort.Order> sorts = new ArrayList();
		sorts.add(Sort.Order.desc("createDate"));
		
		Pageable pageable = PageRequest.of(page, 10 , Sort.by(sorts)); 
		
		System.out.println("서비스 까지 잘 호출");
		
		return this.userRepository.findAll(pageable); 
	}
	
	//상세 페이지 처리 메소드
	public Users getUsers(Integer idx) {
		Optional<Users> users = this.userRepository.findById(idx);
		
		if(users.isPresent()) {
			return users.get();
		}else {
			throw new DataNotFoundException("요청을 찾지 못하겠네요");
		}
	}
	
	public void create(String name, String pass, String email) {
		Users u = new Users();
		u.setName(name);
		u.setPass(pass);
		u.setEmail(email);
		u.setCreateDate(LocalDateTime.now());
		
		this.userRepository.save(u);
	}
	
}
