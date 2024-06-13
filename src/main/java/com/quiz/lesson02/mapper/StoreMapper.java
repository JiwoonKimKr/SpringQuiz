package com.quiz.lesson02.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import com.quiz.lesson02.domain.Store;

@Mapper
public interface StoreMapper { //class로 생성했더라도 interface로 바로 바꾸면 됨

	//Input: 없음
	//Output: List<Store>
	public List<Store> selectListStore(); //쿼리문 selete에서 차용;DB에 가까워졌으니까!
}
