package com.quiz.weatherHistory.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeatherHistory {
	private int id;
	private LocalDate date;
	private String weather;
	private double temperatures;
	private double precipitation;
	private String microDust;
	private double windSpeed;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return this.date;
	}
	public void setDate(String strDate) {
		this.date = LocalDate.parse(strDate);
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public double getTemperatures() {
		return temperatures;
	}
	public void setTemperatures(double temperatures) {
		this.temperatures = temperatures;
	}
	public double getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(double precipitation) {
		this.precipitation = precipitation;
	}
	public String getMicroDust() {
		return microDust;
	}
	public void setMicroDust(String microDust) {
		this.microDust = microDust;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return "WeatherHistory [id=" + id + ", date=" + date + ", weather=" + weather + ", temperatures=" + temperatures
				+ ", precipitation=" + precipitation + ", microDust=" + microDust + ", windSpeed=" + windSpeed
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	
	
}
