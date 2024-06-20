package com.quiz.lesson04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.RealtorDTO;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
	@Autowired
	private RealtorBO realtorBO;
	
	//localhost/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String showAddRealtorView() {
		return "lesson04/addRealtor";
	}
	
	//새로운 가입자 추가 및 바로 열람
	@PostMapping("/add-realtor")
	public String addRealtor(@ModelAttribute RealtorDTO realtor
							, Model model) {
		
		//DTO DB 저장
		realtorBO.addRealtor(realtor);
		
		//방금 입력한 DTO 조회
		RealtorDTO target = realtorBO.getRealtorById(realtor.getId());
			// 방금 추가된 객체의 id 바로 끌어와서 조회
		
		//중간 매게체 model로 
		model.addAttribute("title", "공인중계사 정보");
		model.addAttribute("realtor", target);
		
		return "lesson04/realtorInfo";
	}
	
	//특정 ID 조회
	@GetMapping("/realtor")
	public String showRealtor(@RequestParam("id")int id
						, Model model) {
		//DB Insert
		RealtorDTO target = realtorBO.getRealtorById(id);
		
		// DB selectById
		model.addAttribute("title", "해당 ID 공인중계사 정보");
		
		// Model
		model.addAttribute("realtor", target);
		// View
		return "lesson04/realtorInfo";
	}
}
