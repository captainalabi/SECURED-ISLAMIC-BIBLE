package com.alabi.app.evidence.entity;

public record IslamicBibleDTO(
		 Integer id,		
		 String topic,		
		 String bibleVersion,		
		 String bibleBook,		
		 int bibleChapter,		
		 int bibleVerse,		
		 String bibleText,		
		 String bibleExplanation,		
		 int quranicChapter,			
		 int quranicVerse,		
		 String quranicText,		
		 String quranicExplanation
		) {
}
