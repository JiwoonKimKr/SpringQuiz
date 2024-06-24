package com.quiz.lesson05.domain;

import java.time.*;

public class Member {
	private String name;
	private String phoneNumber;
	private String email;
	private String nationality;
	private String introduce;
	private LocalDate birth;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
//		if(phoneNumber.startsWith("010") == false) {
//			return "유효하지 않은 전화번호";
//		}
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
//		String[] arrayStr = email.split("@");
//		String str = "<b>".concat(arrayStr[0]).concat("</b>@").concat(arrayStr[1])
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getIntroduce() {
//		if(introduce.length() > 15) {
//			return introduce.substring(0, 15).concat("...");
//		}
		return this.introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	
	
}
