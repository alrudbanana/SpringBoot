package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
	//JPA에서 Question테이블을 select, Insert,update,delete
	
	//JPA의 CRUD 메소드 : 
		// save() : Insert, Update, delete
		// findAll()
		// findById
		//정의해서 사용 : findBySubject() .....
	
	
	
	
	//Question테이블을 SQL 쿼리를 사영하지 않고 JPA 메소드를 사용해서 CRUD하는 Repository 
		//JpaRepository<Question,Integer>
		//Question:JPA메소드에서 쿼리할 엔티티 클래스 
		//Integer:엔티티 클래스의 Primary Key컬럼의 데이터 타입 
	
	
	//하나의 컬럼을 조건으로 처리된 값 가져오기 
	//	findById() : question 테이블의 Primary key컬럼이므로 기본 제공됨
	//select * from 
	
	//제목으로 테이블 조회 : select * from question where subject =?
	Question findBySubject(String subject);	//검색결과가 1개
	
	Question findByContent(String content);
	
	//응답 결과가 여러건인 경우에는 리포지터리 메서드의 리턴 타입을 Question이 아닌 List<Question> 으로 해야 한다
	//두개의 속성을 조회하기 위해서 추가 해야함 
	//select * from question where subject like '%sbb%'
	//findBy: where 
	List<Question> findBySubjectLike(String subject);
	Question findBySubjectAndContent(String subject, String content);
	
	//정렬해서 출력 : orderBy
	List<Question> findBySubjectLikeOrderByCreateDateAsc(String subject);
	List<Question> findBySubjectLikeOrderByCreateDateDesc(String subject);
	//select * from question order by createData asc  : 오름차순 정렬 
	//select * from question order by createData desc  : 오름차순 정렬 
	
	//모든 레코드를 정렬해서 출력 
	//select * from question order by create_date asc;
	//select * from question order by create_date desc;
	List <Question> findAllByOrderByCreateDateAsc();
	
	
	//Update : save()
	
	//Delete : save()
	//=> 쿼리가 자동으로 만들어진다 
	
	
}
