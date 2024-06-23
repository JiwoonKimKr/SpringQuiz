package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Review;
import com.quiz.lesson02.mapper.ReviewMapper;

@Service
public class ReviewBO {
	@Autowired
	private ReviewMapper reviewMapper;

	public List<Review> getReviewsByStoreId(int storeId) {
		return reviewMapper.selectReviewsByStoreId(storeId);
	}
	
}
