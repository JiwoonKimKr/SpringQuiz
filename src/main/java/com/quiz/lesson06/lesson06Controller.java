package com.quiz.lesson06;

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

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class lesson06Controller {
	@Autowired
	private BookmarkBO bookmarkBO;

	// localhost/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	//AJAX가 하는 요청
	//즐겨찾기 추가 로직
	@ResponseBody
	@PostMapping("/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name
			, @RequestParam("url") String url ) {
		//DB Insert
		bookmarkBO.addBookmark(name, url);
		
		//성공한 경우의 JSON
		//AJAX Response String
		// ResponseBody로 이제 JSON을 응답한다.
			//내려보내는 일련의 규칙
			// {"code" : 200, "result": "성공" }
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result; //Map<>인 result를 리턴하면 JSON String을 응답한다.
	}
	
	@GetMapping("/List-bookmarks-view")
	public String showListBookmarks(Model model) {
		
		List<Bookmark> listBookmarks = bookmarkBO.getListBookmarks();
		
		model.addAttribute("listBookmarks", listBookmarks);
		return "lesson06/listBookmarks";
	}
	
	@ResponseBody
	@PostMapping("/check-url-duplicate")
	public Map<String, Object> checkUrlDuplicate(
			@RequestParam("url") String url) {
		//DB Select
		Boolean isDuplicate = bookmarkBO.checkUrlDuplicate(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", isDuplicate ? "fail" : "success");
		return result;
	}
	
	// http://localhost/lesson06/delete-bookmark?id=
	@ResponseBody
	@DeleteMapping("/delete-bookmark")
	public Map<String, Object> deleteBookmarkById(
			@RequestParam("id") int id) {
		int rowCount = bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		if(rowCount > 0) {
			result.put("code", 200);
			result.put("result", "success");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 항목이 존재하지 않습니다.");
		}
		return result; 
	}
	
}
