package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson04.domain.SellerDTO;

@Mapper
public interface SellerMapper {

	int insertSeller(SellerDTO sellerDTO);

	SellerDTO selectSellerAddedLatest();

	SellerDTO selectSellerById(int id);

}
