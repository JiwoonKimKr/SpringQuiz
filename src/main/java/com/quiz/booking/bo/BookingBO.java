package com.quiz.booking.bo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

	public Booking getBookingByNamePhoneNumber(String name, String phoneNumber) {
		return bookingMapper.selectBookingByNamePhoneNumber(name, phoneNumber);
	}

	public int addBooking(String name, int headcount, int day, String date, String phoneNumber) {
		return bookingMapper.insertBooking(name, headcount, day, date, phoneNumber);
	}

}
