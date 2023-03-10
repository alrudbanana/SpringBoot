package com.mysite.sbb2.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersForm {


	@NotEmpty(message="이름은 필수 사항입니다.")  //subject 값이 비어있을때 작동 
	@Size (max=200)							//subject 값을 최대 200자까지 
	private String name; 
	
	
	@NotEmpty(message="비밀번호은 필수 항목 입니다. ")
	private String pass; 
	
	@NotEmpty(message="이메일은 필수 항목 입니다. ")
	private String email;

		

	}
