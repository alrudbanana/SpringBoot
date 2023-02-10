package com.mysite.sbb.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor //final 필드의 생성자를 자동으로 만들어서 생성자를 통한 의존성 주입 
@Controller
public class QuestionController {

	/* 클래스를 객체로 생성 어노테이션 (빈 (객체)등록, Spring Framework)
	 * @Component: 일반적인 클래스를 객체화
	 @Controller : 클라이언트 요청을 받아서 처리 , controller
	 	//1. 클라이언트 요청을 받는다. @GetMapping, @PostMapping
	 	 2. 비즈니스 로직 처리, Service의 메소드 호출 
	 	 
	 @Service: DAO의 메소드를 인터페이스로 생성 후 인터페이스의 메소드를 구현한 클래스 
	 	-유지보수를 쉽게 하기 위해서 (약결합) 
	 @Repository : DAO 클래스를 빈등록	 
	 */
	
	/*
	 1. @Autowired : DI (의존성 주입) : Spring Framework 의 생성된 빈(객체)를 주입, 타입을 찾아서 주입 
	 같은 타입의 객체가 존재할 경우 문제가 발생될 수 있다. 
	 2. 생성자를 통한 의존성 주입(권장방식) 
	 3.  Setter를 사용한 값 주입 
	 
	 
	 */
	
	//생성자를 통한 의존성 주입 <== 권장하는 방식 
		//controller에서 직접 Repository를 접근하지 않고 service를 접근 하도록함 
	private final QuestionService questionservice;
	//private final QuestionRepository questionrepository;
	
	@GetMapping("/question/list") //http://localhost:9292/question/list
	@PostMapping("/question/list")
	
	//@ResponseBody 요청을 요청한 브러우저에 출력(String 값을 출력)
	public String list(Model model) {
		
		//1.클라이언트 요청 정보 : http://localhost:9292/question/list
		
		//2.비지니스 로직을 처리 
		List<Question> questionList =
				//this.questionrepository.findAll();
				this.questionservice.getList();
		
		
		//3.뷰(view)페이지로 전송 
		model.addAttribute("questionList", questionList);
		
		return "question_list";
	}
	
	//상세페이지를 처리하는 메소드 : /question/deatail/1(변수값) 
	@GetMapping("/question/detail/{id}")
	public String detail( Model model, @PathVariable("id") Integer id) { 
		Question q= 
		this.questionservice.getQuestion(id);
		
		
		//Model 객체에 담아서 클라이언트에게 전송
		model.addAttribute("question", q); //클라이언트에서 퀘스쳔 객체를 응답받아옴 
		return "question_detail";	//template : question_detail.html 
	}
	
}