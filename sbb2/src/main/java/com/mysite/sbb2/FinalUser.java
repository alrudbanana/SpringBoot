package com.mysite.sbb2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor 

public class FinalUser {
	
	
	private final int idx;
	private final String name;
	
	
	public static void main(String[] args) {
		FinalUser user = new FinalUser(40,"이똥꼬");
		
		System.out.println(user);
	}

}
