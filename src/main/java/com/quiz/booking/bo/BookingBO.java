package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	@Autowired
	private BookingMapper bookingMapper;

	public List<Booking> getListBookings() {
		return bookingMapper.selectListBookings();
	}

	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}

	public Booking getBookingById(int id) {
		return bookingMapper.selectBookingById(id);
	}

	public Map<String, Object> getMapBookingNearestByNamePhoneNumber(String name, String phoneNumber) {
		
		List<Booking> listBookings = bookingMapper.selectListBookingsByNamePhoneNumber(name, phoneNumber);
		
		Iterator<Booking> iter = listBookings.iterator(); //DB에서 받아온 리스트 중 오늘 이전 내용들은 삭제
		while(iter.hasNext())  {
			Booking booking = iter.next();
			if(booking.getDate().isBefore(LocalDate.now())) {
				iter.remove();
			}
		}
		listBookings.sort(Comparator.comparing(Booking::getDate));
		
		Booking booking = listBookings.get(0); //예약 리스트 중 가장 최근 것만 Map에 담기 
		
		Map<String, Object> mapBooking = new HashMap<>();
		mapBooking.put("name", booking.getName());
		mapBooking.put("date", booking.getDate());
		mapBooking.put("day", booking.getDay());
		mapBooking.put("headcount", booking.getHeadcount());
		mapBooking.put("state", booking.getState());
		
		return mapBooking;
	}

	public int addBooking(String name
						, int headcount
						, int day
						, String date
						, String phoneNumber) {
		return bookingMapper.insertBooking(name, headcount, day, date, phoneNumber);
	}

}
