package com.alabi.app.evidence.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alabi.app.evidence.entity.BibleBook;
import com.alabi.app.evidence.entity.BibleBookDTO;
import com.alabi.app.evidence.entity.BibleDTOMapper;
import com.alabi.app.evidence.repository.BibleBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BibleBookServiceImpl implements BibleBookService{

	@Autowired
	private final BibleBookRepository bibleBookRepository;
	
	@Autowired
	private final BibleDTOMapper bibleDTOMapper;
	
	@Override
	public void create(BibleBookDTO bibleBookDTO) {
		bibleBookRepository.save(new BibleBook(bibleBookDTO.id(), bibleBookDTO.bibleBook()));
	}

	@Override
	public List<BibleBookDTO> read() {
		return bibleBookRepository.findAll().
				stream().map(bibleDTOMapper).collect(Collectors.toList());
	}

	@Override
	public BibleBookDTO findById(Integer id) throws Exception {
		return bibleBookRepository.findById(id).
				map(bibleDTOMapper)
				.orElseThrow(() -> new Exception("Student with [%s] not found".formatted(id)));
	}

	@Override
	public void deleteById(Integer id) {
		bibleBookRepository.deleteById(id);
	}

}
