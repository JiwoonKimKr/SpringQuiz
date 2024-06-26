package com.quiz.weatherHistory.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.weatherHistory.domain.WeatherHistory;
import com.quiz.weatherHistory.mapper.WeatherMapper;

@Service
public class WeatherBO {
	@Autowired
	private WeatherMapper weatherMapper;

	public List<WeatherHistory> getListWeatherHistory() {
		return weatherMapper.selectListWeatherHistory();
	}

	public void addWeatherHistory(WeatherHistory weatherHistory) {
		weatherMapper.insertWeatherHistory(weatherHistory);
	}

	public void addWeatherHistory(
			LocalDate date
			, String weather
			, String microDust
			, double temperatures
			, double precipitation
			, double windSpeed) {

		weatherMapper.insertWeatherHistoryAsMap(date, weather, microDust, temperatures, precipitation, windSpeed);
	}

	
}
