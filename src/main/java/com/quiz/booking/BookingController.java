package com.quiz.booking;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;

@RequestMapping("/booking")
@Controller
public class BookingController {
	@Autowired
	private BookingBO bookingBO;
	
	//http://localhost/booking/booking-list-view
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		List<Booking> listBookings = bookingBO.getListBookings();
		
		model.addAttribute("listBookings", listBookings);
		
		return "booking/bookingList";
	}
	
	//http://localhost/booking/make-booking-view
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	//http://localhost/booking/check-booking-view
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
}
