package com.quiz.booking;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	///http://localhost/booking/check-booking
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> getBookingByNamePhoneNumber(
			@RequestBody Map<String, Object> data){
		
		String nameForCheck = (String) data.get("name");
		String phoneNumberForCheck = (String) data.get("phoneNumber");
		
		Map<String, Object> mapBooking = bookingBO.getMapBookingNearestByNamePhoneNumber(nameForCheck, phoneNumberForCheck);
		Map<String, Object> result = new HashMap<>();
		if(mapBooking != null) {
			result.put("code", 200);
			result.put("result", mapBooking);
		} else {
			result.put("code", 500);
			result.put("error_message", "예약 내역이 존재하지 않습니다.");
		}
		
		return result;
	}
	
	///http://localhost/booking/make-booking
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name
			, @RequestParam("headcount") int headcount
			, @RequestParam("day") int day
			, @RequestParam("date") String date
			, @RequestParam("phoneNumber") String phoneNumber){
		int rowCoungInsert = bookingBO.addBooking(name, headcount, day, date, phoneNumber);
				
		Map<String, Object> result = new HashMap<>();
		if(rowCoungInsert > 0) {
			result.put("code", 200);
			result.put("result", "예약 추가 성공하였습니다. \n 현재 대기중 입니다.");
		} else {
			result.put("code", 500);
			result.put("error_message", "예약을 추가하지 못하였습니다.");
		}
		
		return result;
	}

	//http://localhost/booking/delete-booking?id=
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id")int id) {
		//DB Delete
		int rowCountDelete = bookingBO.deleteBookingById(id);
		
		//응답 값
		Map<String, Object> result = new HashMap<>();
		if(rowCountDelete > 0) {
			result.put("code", 200);
			result.put("result", "success");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
				//오타 주의: Key 명칭 아예 복사해서 붙여넣기
		}
		
		return result;
	}
}
