package com.alabi.app.evidence.entity;

import java.util.function.Function;

import org.springframework.stereotype.Service;

@Service
public class BibleVersionDTOMapper implements Function<BibleVersion, BibleVersionDTO> {

	@Override
	public BibleVersionDTO apply(BibleVersion bibleVersionDTO) {
		
		return new BibleVersionDTO(
				bibleVersionDTO.getId(),
				bibleVersionDTO.getVersion()
				);
	}

	
}
