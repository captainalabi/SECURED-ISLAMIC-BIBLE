package com.alabi.app.evidence.service;

import java.util.List;

import com.alabi.app.evidence.entity.BibleBookDTO;

public interface BibleBookService {

	void create(BibleBookDTO bibleBookDTO );
	List<BibleBookDTO> read();
	BibleBookDTO findById(Integer id) throws Exception;
	void deleteById(Integer id);
}
