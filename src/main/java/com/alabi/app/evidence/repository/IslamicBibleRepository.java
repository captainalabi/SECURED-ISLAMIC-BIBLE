package com.alabi.app.evidence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alabi.app.evidence.entity.IslamicBible;

@Repository
public interface IslamicBibleRepository extends JpaRepository<IslamicBible, Integer>{

	@Transactional
	@Query
	("SELECT i from IslamicBible i WHERE i.topic LIKE %?1%"
			+ "OR i.bibleVersion LIKE %?1%"
			+ "OR i.bibleBook LIKE %?1%"
			+ "OR i.bibleVerse LIKE %?1%"
			+ "OR i.bibleChapter LIKE %?1%"
			+ "OR i.bibleText LIKE %?1%"
			+ "OR i.bibleExplanation LIKE %?1%"
			+ "OR i.quranicChapter LIKE %?1%"
			+ "OR i.quranicVerse LIKE %?1%"
			+ "OR i.quranicText LIKE %?1%"
			+ "OR i.quranicExplanation LIKE %?1%")
	public List<IslamicBible> findAll(String keyword);
	
	Optional<IslamicBible>findByBibleExplanation(String bibleExplanation);
	Optional<IslamicBible>findByQuranicExplanation(String quranicExplanation);
}
