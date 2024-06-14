package com.quiz.lesson03.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	public RealEstate selectRealEstateBy(int id);

	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
}
