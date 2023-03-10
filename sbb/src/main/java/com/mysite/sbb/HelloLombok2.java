package com.mysite.sbb;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor


public class HelloLombok2 {
	private int seq; 
	private String title; 
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	
	public static void main(String[] args) {
		//객체 생성 후 test
		HelloLombok2 lombok2 = new HelloLombok2(); 
		//값 주입 
		lombok2.setSeq(4);
		lombok2.setTitle("웃기지마세요");
		
		//getter를 사용해서 lombok2 객체에 저장된 메모리 필드의 값을 출력 
		System.out.println(lombok2.getSeq());
		System.out.println(lombok2.getTitle());
		System.out.println(lombok2.getRegdate());
		
		//toString 
		System.out.println(lombok2);
		
	}

}
