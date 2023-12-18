package com.alabi.app.evidence.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alabi.app.evidence.entity.IslamicBible;
import com.alabi.app.evidence.entity.IslamicBibleDTO;
import com.alabi.app.evidence.entity.IslamicBibleDTOMapper;
import com.alabi.app.evidence.repository.IslamicBibleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IslamicBibleServiceImpl implements IslamicBibleService{

	@Autowired
	private final IslamicBibleRepository islamicBibleRepository;
	
	@Autowired final IslamicBibleDTOMapper islamicBibleDTOMapper;
	
	
	@Override
	public void createIslamicBible(IslamicBibleDTO islamicBibleDTO) {
		IslamicBible existingIslamicBibleB = islamicBibleRepository.findByBibleExplanation(null).orElse(null);
		IslamicBible existingIslamicBibleQ = islamicBibleRepository.findByQuranicExplanation(null).orElse(null);
		if(existingIslamicBibleB == null && existingIslamicBibleQ  == null) {
			islamicBibleRepository.save(
					new IslamicBible(
							islamicBibleDTO.id(),
							islamicBibleDTO.topic(),
							islamicBibleDTO.bibleVersion(),
							islamicBibleDTO.bibleBook(),
							islamicBibleDTO.bibleChapter(),
							islamicBibleDTO.bibleVerse(),
							islamicBibleDTO.bibleText(),
							islamicBibleDTO.bibleExplanation(),
							islamicBibleDTO.quranicChapter(),
							islamicBibleDTO.quranicVerse(),
							islamicBibleDTO.quranicText(),
							islamicBibleDTO.quranicExplanation()
							)
					);
		}	
	}

	@Override
	public List<IslamicBibleDTO> readIslamicBible() {		
		return islamicBibleRepository.findAll()
				.stream()
				.map(islamicBibleDTOMapper)
				.collect(Collectors.toList());
	}

	@Override
	public void updateIslamicBible(IslamicBibleDTO islamicBibleDTO) {		
		islamicBibleRepository.save(
				new IslamicBible(
						islamicBibleDTO.id(),
						islamicBibleDTO.topic(),
						islamicBibleDTO.bibleVersion(),
						islamicBibleDTO.bibleBook(),
						islamicBibleDTO.bibleChapter(),
						islamicBibleDTO.bibleVerse(),
						islamicBibleDTO.bibleText(),
						islamicBibleDTO.bibleExplanation(),
						islamicBibleDTO.quranicChapter(),
						islamicBibleDTO.quranicVerse(),
						islamicBibleDTO.quranicText(),
						islamicBibleDTO.quranicExplanation()
						)
				);
	}

	@Override
	public void deleteIslamicBibleById(Integer id) {		
		islamicBibleRepository.deleteById(id);
	}

	@Override
	public IslamicBibleDTO searchById(Integer id) {		
		return islamicBibleRepository.findById(id).map(islamicBibleDTOMapper).get();
	}

	@Override
	public List <IslamicBibleDTO> findAll(String keyword) {
		if(keyword != null) {
			return islamicBibleRepository.findAll(keyword)
					.stream()
					.map(islamicBibleDTOMapper)
					.collect(Collectors.toList());
		}
		return islamicBibleRepository.findAll()
				.stream()
				.map(islamicBibleDTOMapper)
				.collect(Collectors.toList());
	}
}
