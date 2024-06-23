package com.quiz.lesson02;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController //Spring Bean으로 등록시켜줌
public class Lesson02Quiz01RestController {
	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz02_1(){
		List<Store> list = storeBO.getListStores();
		return list;
		
	}
	
}
