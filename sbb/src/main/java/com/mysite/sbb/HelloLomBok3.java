package com.mysite.sbb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor	//기본생성자 , @AllArgsConstructor사용시 반드시 있어야함 
@AllArgsConstructor // 객체 생성시 모든 필드의 값을 입력받아 필드의 초기값을 할당 

public class HelloLomBok3 {
	
	private String hello; 	//필드 : 메인 메소드 x 
	private int lombok;	
	
	//@NoArgsConstructor: 기본생성자 사용시 생성자의형태 
	// public HelloLombok3() {} 
	
	//@AllArgsConstructor :  객체 생성시 모든 필드의 값을 입력받아 필드의 초기값을 할당 
	/*public HelloLombok3(String hello, int lombok){ 
	  		this.hello = hello;
	  		this.lombok = lombok;
	} 
	  
	*/
	public static void main(String[] args) {
		//값 출력 확인 
		
		//@AllArgsConstructor 테스트 : 객체 생성시에 필드의 값을 할당
		HelloLomBok3 lombok3 = new HelloLomBok3("안녕",55); // 생성자 호출 
		
		System.out.println(lombok3);
	}

}
