package com.quiz.lesson05;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Lesson05Quiz01Controller {

	@GetMapping("/lesson05/quiz01")
	public String quiz01_1(
			@RequestParam("n1") int num1,
			@RequestParam("n2") int num2,
			Model model) {
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		
		return "lesson05/quiz01";
	}
}
