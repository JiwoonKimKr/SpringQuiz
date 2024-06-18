package com.quiz.lesson03.domain;

import java.time.LocalDateTime;

public class RealEstate {
	private int id;
	private int realtorId;
	private String address;
	private int area;
	private String type;
	private int price;
	private Integer rentPrice;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	@Override
	public String toString() {
		return "RealEstate [id=" + id + ", realtorId=" + realtorId + ", address=" + address + ", area=" + area
				+ ", type=" + type + ", price=" + price + ", rentPrice=" + rentPrice + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRealtorId() {
		return realtorId;
	}
	public void setRealtorId(int realtorId) {
		this.realtorId = realtorId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}

	public RealEstate updateRealEstate(
			RealEstate target
			, Integer realtorId
			, String address
			, Integer area
			, String type
			, Integer price
			, Integer rentPrice2) {
		
		if(realtorId != null) target.setRealtorId((int) realtorId);
		if(address != null) target.setAddress(address);
		if(area != null) target.setArea((int)area);
		if(type != null) target.setType(type);
		if(price != null) target.setPrice((int)price);
		if(rentPrice != null) target.setPrice((int)rentPrice);		
		return target;
	}

}
