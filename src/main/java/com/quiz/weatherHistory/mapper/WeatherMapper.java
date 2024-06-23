package com.quiz.weatherHistory.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.weatherHistory.domain.WeatherHistory;

@Mapper
public interface WeatherMapper {

	List<WeatherHistory> selectListWeatherHistory();

	int insertWeatherHistory(WeatherHistory weatherHistory);

}
