package com.quiz.weatherHistory.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.weatherHistory.domain.WeatherHistory;

@Mapper
public interface WeatherMapper {

	List<WeatherHistory> selectListWeatherHistory();

	int insertWeatherHistory(WeatherHistory weatherHistory);

	int insertWeatherHistoryAsMap(
			@Param("date") LocalDate date
			,@Param("weather") String weather
			,@Param("microDust") String microDust
			,@Param("temperatures") double temperatures
			,@Param("precipitation") double precipitation
			,@Param("windSpeed") double windSpeed);

}
