package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.SellerDTO;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;

	public void addSeller(SellerDTO sellerDTO) {
		sellerMapper.insertSeller(sellerDTO);
	}

	public SellerDTO getSellerAddedLatest() {
		SellerDTO latest = sellerMapper.selectSellerAddedLatest();
		return latest;
	}
	
	
}
