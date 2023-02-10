package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class UsersController {

	private final UsersService usersService;
	//private final UserRepository userrepository;
	
	@GetMapping("/users/list")
	@PostMapping("/users/list")
	
	public String list(Model model) {
		List<Users> userslist = 
				this.usersService.getList();
		
	model.addAttribute("userslist", userslist);
			
			return "users_list";
				
	}
	
	//상세 페이지를 처리하는 메소드 : /users/detail/idx(변수값)
	@GetMapping("/users/list/{idx}")
	public String detail(Model model, @PathVariable("idx") Integer idx) {
		Users u =
				this.usersService.getUsers(idx);
		
		model.addAttribute("users",u);
		return "users_detail";
		
	}
	
}
