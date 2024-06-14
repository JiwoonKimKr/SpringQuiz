package com.quiz.lesson03.bo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	@Autowired
	private RealEstateMapper realEstateMapper;

	public RealEstate getRealEstateBy(int id) {
		return realEstateMapper.selectRealEstateBy(id);
	}
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
}
