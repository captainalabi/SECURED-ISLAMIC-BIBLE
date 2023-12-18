package com.alabi.app.evidence.entity;

import java.util.function.Function;

import org.springframework.stereotype.Service;

@Service
public class IslamicBibleDTOMapper implements Function<IslamicBible, IslamicBibleDTO> {

	@Override
	public IslamicBibleDTO apply(IslamicBible islamicBible) {
		return new IslamicBibleDTO(
				islamicBible.getId(),
				islamicBible.getTopic(),
				islamicBible.getBibleVersion(),
				islamicBible.getBibleBook(),
				islamicBible.getBibleChapter(),
				islamicBible.getBibleVerse(),
				islamicBible.getBibleText(),
				islamicBible.getBibleExplanation(),
				islamicBible.getQuranicChapter(),
				islamicBible.getQuranicVerse(),
				islamicBible.getQuranicText(),
				islamicBible.getQuranicExplanation()
				);
	}

	
}
