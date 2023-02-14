package com.mysite.sbb.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
														// Question 컬럼, Id의 타입 = Integer
public interface QuestionRepository extends JpaRepository<Question, Integer> {
	//JPA에서 Question 테이블을 Select, Insert, Update, delete
	// JPA의 CRUD 메소드 : 
			// save() : Insert, Update, delete
			// findAll()
			// findById()
			// 정의해서 사용 : findBySubject 
	
	
	// Question 테이블을 SQL 쿼리를 사용하지 않고 JPA 메소드를 사용해서 CRUD하는 Repository
		//JpaRepository<Question, Inter>
			// Question : JPA 메소드에서 쿼리할 엔티티 클래스
			// Integer : 엔티티 클래스의 Primary Key 컬럼의 데이터 타입

	//	@Repository
	// 	DAO
	
	// JPA 메소드 선언하기 !! 
	
	// 하나의 컬럼을 조건으로 처리된 값 가져오기
	// findById() : Question 테이블의 Primary Key 컬럼이므로 기본 제공됨.
	// ID 컬럼 외에 선언하고 사용해야 한다.
	
	// Where 조건에 들어오는 값을 검색해서 가져온다.
	// select * from question where subject=?		// 검색 결과가 1개일 때 처리
	//Question findBySubject(String subject);
	
	// select * from question where content=?
	Question findByContent(String content);			// 검색 결과가 1개일 때 처리
	
	// select * from question where subject like '%sbb%'
	List<Question> findBySubjectLike(String subject);	
	
	//content 컬럼을 조건으로 검색
	// select * from question where content like'%내용%'
	List<Question> findByContentLike(String content);
	
	// select * from question where subject like '%sbb%' or content like '%내용%'
	List<Question> findBySubjectLikeOrContentLike (String subject, String content);
	
	// 조건을 사용해서 출력 후 정렬해서 출력 : Order By
	// slect * from question where subject=? order by createDate asc : 오름차순
	List<Question> findBySubjectLikeOrderByCreateDateAsc(String subject);
	// slect * from question where subject=? order by createDate desc : 내림차순
	List<Question> findBySubjectLikeOrderByCreateDateDesc(String subject);
	
	//모든 레코드를 정렬해서 출력
	// Select * from question order by create_date asc
	List <Question> findAllByOrderByCreateDateAsc();
	// Select * from question order by create_date asc
	List <Question> findAllByOrderByCreateDateDesc();
	
	// Update : save()
	
	// Delete : save()
	
	// 페이징을 처리하기 위한 메서드 생성
	// select * from question : pageable 변수에 : page, 레코드 수를 넣어주면(10)
	// JPA에서 페이지 번호는 0부터 시작
	// 출력할 레코드 수를 JPA에 알려주면 내부에서 JPA가 전체 레코드(1000)/10 = 100 페이지가 나온다.
	Page<Question> findAll(Pageable pageable);
	
	
}