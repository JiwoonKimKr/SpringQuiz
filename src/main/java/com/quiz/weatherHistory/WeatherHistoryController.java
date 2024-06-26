package com.quiz.weatherHistory;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weatherHistory.bo.WeatherBO;
import com.quiz.weatherHistory.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {
	@Autowired
	private WeatherBO weatherBO;

	//localhost/weather-history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		List<WeatherHistory> listWeatherHistory = new ArrayList<>();
		
		listWeatherHistory = weatherBO.getListWeatherHistory();
		
		model.addAttribute("listWeatherHistory", listWeatherHistory);
		return "weather_history/weatherList";
	}
	
	//localhost/weather-history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
//	@PostMapping("/add-weather")
//	public String addWeather(@ModelAttribute WeatherHistory weatherHistory) {
//		
//		weatherBO.addWeatherHistory(weatherHistory);
//		
//		return "redirect:weather-list-view";
//	}
	@PostMapping("/add-weather")
	public String addWeather(
//			@RequestParam("date") String date
//			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date
			@RequestParam("date") LocalDate date
			,@RequestParam("weather") String weather
			,@RequestParam("microDust") String microDust
			,@RequestParam("temperatures") double temperatures
			,@RequestParam("precipitation") double precipitation
			,@RequestParam("windSpeed") double windSpeed) {
		
		//DB Insert
		
		weatherBO.addWeatherHistory(date, weather, microDust, temperatures, precipitation, windSpeed);
		
		return "redirect:/weather-history/weather-list-view";
	}
}
