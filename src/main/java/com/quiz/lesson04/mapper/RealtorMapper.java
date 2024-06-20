package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson04.domain.RealtorDTO;

@Mapper
public interface RealtorMapper {

	int insertRealtor(RealtorDTO realtor);

	RealtorDTO selectRealtorById(int id);

}
