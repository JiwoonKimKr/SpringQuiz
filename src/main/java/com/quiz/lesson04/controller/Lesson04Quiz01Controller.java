package com.quiz.lesson04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.SellerDTO;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	@Autowired
	private SellerBO sellerBO;
	
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	@PostMapping("/add-seller")
	public String addSeller(@ModelAttribute SellerDTO sellerDTO) {
		//DB
		sellerBO.addSeller(sellerDTO);
		
		//View
		return "lesson04/afterAddSeller";
	}
	
	@GetMapping("/seller-info-view")
	public String showSellerAddedLatest(Model model) {
		SellerDTO latest = sellerBO.getSellerAddedLatest();
		model.addAttribute("seller", latest);
		return "lesson04/sellerInfo";
	}
	
}
