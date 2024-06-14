package com.quiz.lesson03.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	public RealEstate selectRealEstateBy(int id);

	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	public List<RealEstate> selectRealEstateListByAreaAndPrice(@Param("area") int area, @Param("price") int price);
}
