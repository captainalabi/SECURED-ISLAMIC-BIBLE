package com.alabi.app.evidence.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alabi.app.evidence.entity.BibleVersion;
import com.alabi.app.evidence.entity.BibleVersionDTO;
import com.alabi.app.evidence.entity.BibleVersionDTOMapper;
import com.alabi.app.evidence.repository.BibleVersionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BibleVersionServiceImpl implements BibleVersionService{

	@Autowired
	private final BibleVersionRepository bibleVersionRepository;
	
	@Autowired
	private final BibleVersionDTOMapper bibleVersionDTOMapper;
	
	@Override
	public void create(BibleVersionDTO bibleVersionDTO) {
		bibleVersionRepository.save(new BibleVersion(bibleVersionDTO.id(), bibleVersionDTO.version()));
	}

	@Override
	public List<BibleVersionDTO> read() {
		return bibleVersionRepository.findAll().
				stream().map(bibleVersionDTOMapper).collect(Collectors.toList());
	}

	@Override
	public BibleVersionDTO findById(Integer id) throws Exception {
		return bibleVersionRepository.findById(id).
				map(bibleVersionDTOMapper)
				.orElseThrow(() -> new Exception("Student with [%s] not found".formatted(id)));
	}

	@Override
	public void deleteById(Integer id) {
		bibleVersionRepository.deleteById(id);
	}

}
