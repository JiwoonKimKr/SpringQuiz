package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.RealtorDTO;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {
	@Autowired
	private RealtorMapper realtorMapper;

	public void addRealtor(RealtorDTO realtor) {
		realtorMapper.insertRealtor(realtor);
	}
	
	// input: id
	// output: Realtor
	public RealtorDTO getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
	
	
}
