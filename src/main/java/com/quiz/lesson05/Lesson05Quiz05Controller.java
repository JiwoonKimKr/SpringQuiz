package com.quiz.lesson05;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.quiz.lesson02.bo.ReviewBO;
import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Review;
import com.quiz.lesson02.domain.Store;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/lesson05/quiz05")
@Controller
public class Lesson05Quiz05Controller {
	@Autowired
	private StoreBO storeBO;
	@Autowired
	private ReviewBO reviewBO;
	
	//localhost/lesson05/quiz05/index-stores
	@GetMapping("/index-stores")
	public String indexStoresView (Model model) {
		
		List<Store> listStores = storeBO.getListStores();
		
		model.addAttribute("listStores", listStores);
		model.addAttribute("titleArticles", "우리동네 가게");
		
		return "lesson05/quiz05/indexStores";
	}
	
	//localhost/lesson05/quiz05/reviews
	@GetMapping("/reviews")
	public String reviewsView (@RequestParam(value="storeId", required = false) Integer storeId
							, @RequestParam(value="storeName", required = false) String storeName
							, Model model ){
		
		List<Review> listReviews = reviewBO.getReviewsByStoreId(storeId);
		
		model.addAttribute("storeName", storeName);
		model.addAttribute("listReviews", listReviews);
		return "lesson05/quiz05/reviewsStore";	
	}
}
