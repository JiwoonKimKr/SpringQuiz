package com.quiz.booking;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	///http://localhost/booking/get-bookmark
	@ResponseBody
	@PostMapping("/get-booking")
	public Map<String, Object> getBookingById(
			@RequestParam Map<String, String> data){
		String name = data.get("name");
		String phoneNumber = data.get("phoneNumber");
		Booking booking = bookingBO.getBookingByNamePhoneNumber(name, phoneNumber);
		
		Map<String, Object> result = new HashMap<>();
		if(booking != null) {
			result.put("code", 200);
			result.put("result", booking);
		} else {
			result.put("code", 500);
			result.put("error_message", "예약 내역이 존재하지 않습니다.");
		}
		
		return result;
	}
	

	//http://localhost/booking/delete-booking?id=
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id")int id) {
		int rowCountDelete = bookingBO.deleteBookingById(id);
		
		Map<String, Object> result = new HashMap<>();
		if(rowCountDelete > 0) {
			result.put("code", 200);
			result.put("result", "success");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
		}
		
		return result;
	}
}
