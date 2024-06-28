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

	Booking selectBookingByNamePhoneNumber(
			@Param("name") String name
			, @Param("phoneNumber") String phoneNumber);
}
