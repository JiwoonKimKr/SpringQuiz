package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	@Autowired
	private BookmarkMapper bookmarkMapper;

	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}

	public List<Bookmark> getListBookmarks() {
		return bookmarkMapper.selectListBookmarks() ;
	}

	//선생님이 SELECT SQL문을 중복 활용이 용이하도록 BO가 데이터를 가공하시는 방향으로 해석하심
	public Boolean checkUrlDuplicate(String url) {
//		return bookmarkMapper.selectBookmarksByUrl(url).size() > 0;
		List<Bookmark> listBookmarks = bookmarkMapper.selectBookmarksByUrl(url);
		return listBookmarks.isEmpty() == false;
	}

	public int deleteBookmarkById(int id) {
		return bookmarkMapper.deleteBookmarkById(id);
	}
	
}
