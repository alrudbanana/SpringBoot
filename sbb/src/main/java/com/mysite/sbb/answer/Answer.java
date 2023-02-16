package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.users.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity	//JPA에서 자바 객체를 DB 의 테이블에 매핑 

public class Answer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;  //primary key (자동증가. 1,1)
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;	//create_date: 컬럼이름ㅁ이 정해짐 
	
	@ManyToOne
	private Question question; //질문 테이블의 기본키 참조 , (질문테이블 : 부모테이블) 
	
	//siteUser 추가 site_user값이 저장되어 siteUser엔티티와 연결됨 
	@ManyToOne
	 private SiteUser author;
	 
	 private LocalDateTime modifyDate;
	
	/*
	 @column(length=300)
	 private string addr;
	 */
	
	
	
}
