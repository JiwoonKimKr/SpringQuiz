package com.quiz.lesson06;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

	// localhost/lesson06/quiz01/add-bookmark-view
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	@ResponseBody
	@PostMapping("/quiz01/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name
			, @RequestParam("url") String url ) {
		//DB Insert
		bookmarkBO.addBookmark(name, url);
		
		//AJAX Response String
		return "success";
	}
	
	@GetMapping("/quiz01/show-List-bookmarks-view")
	public String showListBookmarks(Model model) {
		
		List<Bookmark> listBookmarks = bookmarkBO.getListBookmarks();
		
		model.addAttribute("listBookmarks", listBookmarks);
		return "lesson06/showListBookmarks";
	}
}
