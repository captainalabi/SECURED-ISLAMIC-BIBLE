package com.alabi.app.evidence.entity;

import java.util.function.Function;

import org.springframework.stereotype.Service;

@Service
public class BibleDTOMapper implements Function<BibleBook, BibleBookDTO> {

	@Override
	public BibleBookDTO apply(BibleBook bibleBook) {
		
		return new BibleBookDTO(
				bibleBook.getId(),
				bibleBook.getBibleBook()
				);
	}

	
}
