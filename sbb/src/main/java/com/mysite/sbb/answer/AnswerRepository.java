package com.mysite.sbb.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
	//JPA 에서 시용 가능한 메소드 상속됨 
	//findAll()
	//findById()
	//save()
	//delete()
	
	
	
	
	
	
	
}
