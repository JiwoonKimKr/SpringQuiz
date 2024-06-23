package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Review;

@Mapper
public interface ReviewMapper {

	List<Review> selectReviewsByStoreId(int storeId);

}
