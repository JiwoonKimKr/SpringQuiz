package com.quiz.lesson03.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper
public interface RealEstateMapper {

	public RealEstate selectRealEstateBy(int id);

	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	//mapper 인터페이스가 xml로 파라미터 전송 시 1개만 보낼 수 있다.
	//@Param Annotation을 사용하면 parameter로 하나의 Map을 구성해준다.
		// 굳이 하나만 parameter가 있는 경우에는 이 annotation 필요 없다!
		// 바인딩으로 넘어할 때 이 인터페이스에서 지정한 변수 명칭은 관계 없다.
			//@Param("<Key name>"의 key 명칭이 중요하다! 
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area,
			@Param("price") int price);

	public int insertRealEstate(RealEstate realEstate);

	public int insertRealEstateAsField
				(@Param("realtorId") int realtorId
				,@Param("address") String address
				,@Param("area") int area
				,@Param("type") String type
				,@Param("price") int price
				,@Param("lentPrice") int lentPrice
			);
}
