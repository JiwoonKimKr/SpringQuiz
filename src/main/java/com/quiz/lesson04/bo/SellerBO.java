package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.SellerDTO;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	@Autowired
	private SellerMapper sellerMapper;

	// input: Params
	// output: void 없음
	public void addSeller(SellerDTO sellerDTO) {
		sellerMapper.insertSeller(sellerDTO);
	}

	// input:x
	// output: Seller(채워져 있거나 null)
	public SellerDTO getSellerAddedLatest() {
		SellerDTO latest = sellerMapper.selectSellerAddedLatest();
		return latest;
	}

	// input: <int> id
	// output: seller(채워지거나 null값)
	public SellerDTO getSellerById(int id) {
			//이미 null이 올 수 없는, id가 존재한 것만 넘겨지니까 int로 선언하는 것이 맞다
		return sellerMapper.selectSellerById(id);
	}
}