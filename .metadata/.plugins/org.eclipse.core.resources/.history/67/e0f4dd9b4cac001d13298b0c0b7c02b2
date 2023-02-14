package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.catalina.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idx;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 100)
	private String pass;
	
	@Column(length = 200)
	private String email; 
	
	private LocalDateTime createDate;
	
	private Integer cnt;
	
	private List<Users> userList;
}
