package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service
public class StoreBO {
	@Autowired //Dependency Injection (DI)
	private StoreMapper storeMapper;
	
	//Input: "Controller가 사실상 아무 것도 보내지 않았다"
	//Output: List<Store>
	
	public List<Store> getListStore() {
		return storeMapper.selectListStore(); //이 함수에 호출된 return 타입의 value를 return하겠다는 말!
	}

}
