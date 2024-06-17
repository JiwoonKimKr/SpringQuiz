package com.quiz.lesson03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Quiz02RestController {
	@Autowired
	private RealEstateBO realEstateBO;
	
	//1)Insert
	@RequestMapping("/1")
	public String addRealEstate() {
		
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		return "입력 성공" + realEstateBO.addRealEstate(realEstate);
	}
	
	//2)field로 insert
	@RequestMapping("/2")
	public String addRealEstateAsField(@RequestParam("realtor_id")int realtorId) {
		
		return "입력 성공: " + realEstateBO.addRealEstateAsField(realtorId,"썅떼빌리버 오피스텔 814호",45,"월세",100000,120);
	}
}
