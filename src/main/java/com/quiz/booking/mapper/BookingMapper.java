package com.quiz.booking.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {

	List<Booking> selectListBookings();
	
	int deleteBookingById(int id);

	Booking selectBookingById(int id);

	List<Booking> selectListBookingsByNamePhoneNumber(
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber);

	int insertBooking(
			@Param("name") String name
			, @Param("headcount") int headcount
			, @Param("day") int day
			, @Param("date") String date
			, @Param("phoneNumber") String phoneNumber);
}
