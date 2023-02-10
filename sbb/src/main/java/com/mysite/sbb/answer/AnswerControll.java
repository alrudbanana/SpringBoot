package com.mysite.sbb.answer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerControll {
	
	private final QuestionService questionservice;
	private final AnswerService answerService;
	
	//http:/localhost:9292/answer/create/1 요청에 대한 답변글 등록 처리 
	@PostMapping("/create/{id}")
	
	public String createAnswer(Model model, @PathVariable("id") Integer id,
		@RequestParam String content) {
		
		Question question = this.questionservice.getQuestion(id); 
		
		this.answerService.create(question, content);
		
		//답변 내용을 저장하는 메ㅔ소드 호출 (service에서 호출)
		return String.format("redirect:/question/detail/%s", id);
	}
	
}
