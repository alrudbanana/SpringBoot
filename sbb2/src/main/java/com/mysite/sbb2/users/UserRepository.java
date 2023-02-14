package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<Users, Integer> {
	
	//이름을 기준으로 찾기 
	Users findByName(String name);
	Users findByNameAndPass(String name, String pass);
	
	
	//아이디 번호 값 찾기
	Users findByidx(Integer idx);
	
	//값 수정 (save)
	
	
	//데이터 값을 정렬 (DESC)
	List<Users> findBynameLikeOrderByCreateDateAsc(String idx);
	List<Users> findBynameLikeOrderByCreateDateDesc(String idx);
	
	//모든 레코드를 정렬해서 출력 
	List <Users> findAllByOrderByCreateDateAsc();
	List <Users> findAllByOrderByCreateDateDesc(); //날짜기준으로 내림차순 
	List<Users> findByNameLike(String Name);
	
	Page<Users> findAll(Pageable pageable); 

}
