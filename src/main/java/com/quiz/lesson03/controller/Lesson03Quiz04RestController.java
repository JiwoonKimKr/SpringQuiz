package com.quiz.lesson03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RequestMapping("/lesson03/quiz04")
@RestController
public class Lesson03Quiz04RestController {
	@Autowired
	private RealEstateBO realEstateBO; 
	
	//localhost/lesson03.quiz04/1?id=8
	@RequestMapping("/1")
	public String deleteRealEstateById(
			@RequestParam("id")int id) {
		
		realEstateBO.deleteRealEstateById(id);
			//int든 뭐는 Return이 넘어와도 안 받으면 그만!
		
		return "삭제 성공 : 1";
	}
}
