package com.alabi.app.evidence.entity;

import org.springframework.format.annotation.NumberFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class IslamicBible {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	@Column(nullable = false)
	private String topic;
	@Column(nullable = false)
	private String bibleVersion;
	@Column(nullable = false)
	private String bibleBook;
	@NumberFormat
	@Column(nullable = false)
	private int bibleChapter;
	@NumberFormat
	@Column(nullable = false)
	private int bibleVerse;		
	@Column(nullable = false, length = 500)
	private String bibleText;	
	@Column(nullable = false, length = 500, unique = true)
	private String bibleExplanation;
	@NumberFormat
	@Column(nullable = false)
	private int quranicChapter;
	@NumberFormat
	@Column(nullable = false)	
	private int quranicVerse;
	@Column(nullable = false, length = 500)
	private String quranicText;
	@Column(nullable = false, length = 500, unique = true)
	private String quranicExplanation;	
}
