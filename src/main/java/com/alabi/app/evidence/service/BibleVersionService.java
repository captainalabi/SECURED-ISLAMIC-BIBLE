package com.alabi.app.evidence.service;

import java.util.List;

import com.alabi.app.evidence.entity.BibleVersionDTO;

public interface BibleVersionService {

	void create(BibleVersionDTO bibleBookDTO );
	List<BibleVersionDTO> read();
	BibleVersionDTO findById(Integer id) throws Exception;
	void deleteById(Integer id);
}
