package com.quiz.lesson03.bo;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//input: area, price
	//output: List<RealEstate>
	/**
	 * 
	 * @param area area(해당 면적 값)보다 넓은 경우 (where `area` > #{area}) 
	 * @param price price(해당 가격)보다 저렴한 경우 (where `price` < #{price})
	 * @return List<RealEstate>
	 */
	public List<RealEstate> getRealEstateListByAreaAndPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaAndPrice(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, int lentPrice) {
	
		return realEstateMapper.insertRealEstateAsField(realtorId,address,area,type,price,lentPrice);
	}
}
