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

	
//1) Select (Read)
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
	
//2) Insert (Create)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, int lentPrice) {
	
		return realEstateMapper.insertRealEstateAsField(realtorId,address,area,type,price,lentPrice);
	}
	
//3) Update (Update)
	//input: id, type, price
	//output: int
	public int updateRealEstateById(int id, Integer realtorId, String address, Integer area, String type, Integer price, Integer rentPrice) {
		RealEstate target = realEstateMapper.selectRealEstateBy(id);
		if(target == null) return -1;
		
		RealEstate updated = target.updateRealEstate(target, realtorId, address, area, type, price, rentPrice);
	
		return realEstateMapper.updateRealEstateById(updated);
	}
	
//4) Delete (Delete)
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
}
