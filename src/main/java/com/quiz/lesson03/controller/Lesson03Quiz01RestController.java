package com.quiz.lesson03.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	@Autowired
	private RealEstateBO realEstateBO;
	
	@GetMapping("/1")
	public RealEstate getRealEstateBy(
			@RequestParam("id") int id ) {
		return realEstateBO.getRealEstateBy(id);
	}
	
	@GetMapping("/2")
	public List<RealEstate> getRealEstateListByRentPrice(
			@RequestParam("rent_price") int rentPrice){
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
	
}
