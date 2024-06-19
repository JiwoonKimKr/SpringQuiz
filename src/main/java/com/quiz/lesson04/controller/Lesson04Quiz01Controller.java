package com.quiz.lesson04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.SellerDTO;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	@Autowired
	private SellerBO sellerBO;
	
	// # 판매자 추가 화면
	// http://localhost/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() { //Request Param 아무것도 없음!
		return "lesson04/addSeller"; //View의 경로
	}
	
	// # DB에 이제 판매자 데이터 저장 => 성공 화면 
	@PostMapping("/add-seller")
	public String addSeller(@ModelAttribute SellerDTO sellerDTO) {
		//DB
		sellerBO.addSeller(sellerDTO);
		
		//View
		return "lesson04/afterAddSeller";
	}
	
	//방금 가입한 판매자 1명 화면
		//또는 id가 기입된 경우 단건 조회도 가능
	// http://localshot/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String showSellerSpecific(
			@RequestParam(value="id", required=false) Integer id //Integer로 선언해야 null값도 조회 가능;
			,Model model){ //이 Model은 Spring Framework관련된 것을 import해야

		//데이터 조회
		//id가 기입된 경우와 없는 경우 딱 두 가지;
		SellerDTO target = (id == null) ? 
				sellerBO.getSellerAddedLatest() : sellerBO.getSellerById(id);
			//Seller 객체가 if문 밖에서 선언되어야

		//MVC Cycle: 산타할아버지와 양말 선물, 그리고 선물받는 어린이
		model.addAttribute("seller", target);
		model.addAttribute("title", "판매자 정보");
		
		return "lesson04/sellerInfo";
	}
	
}
