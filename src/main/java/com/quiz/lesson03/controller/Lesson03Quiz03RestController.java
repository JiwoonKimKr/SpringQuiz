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
					@RequestParam(name = "id", required = true ) int id
					,@RequestParam(name = "realtorId", required = false) Integer realtorId
					,@RequestParam(name = "address", required = false) String address
					,@RequestParam(name = "area", required = false) Integer area
					,@RequestParam(name = "type", required = false) String type
					,@RequestParam(name = "price", required = false) Integer price
					,@RequestParam(name = "rentPrice", required = false) Integer rentPrice){
		int countUpdated = realEstateBO.updateRealEstateById(id, realtorId, address, area , type, price ,rentPrice);
		
		return countUpdated == -1 ? "DB 수정 실패" : "수정 성공: " + countUpdated;
	}
}
