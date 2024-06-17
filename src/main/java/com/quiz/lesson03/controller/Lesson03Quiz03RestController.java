package com.quiz.lesson03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Quiz03RestController {
	@Autowired
	private RealEstateBO realEstateBO;
	
	@RequestMapping("/lesson03/quiz03")
	public String updateRealEstateById(
					@RequestParam("id")int id
					,@RequestParam("type")String type
					,@RequestParam("price")int price){
		return "수정 성공: " + realEstateBO.updateRealEstateById(id, type, price);
	}
}
