package com.quiz.lesson06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;

@RequestMapping("/lesson06")
@Controller
public class lesson06Controller {
	@Autowired
	private BookmarkBO bookmarkBO;

	// localhost/lesson06/quiz01/add-bookmark-view
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	@ResponseBody
	@PostMapping("/quiz01/add-bookmark")
	public String addBookmark() {
		
		return "success";
	}
	
}
