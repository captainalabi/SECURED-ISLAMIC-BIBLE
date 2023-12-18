package com.alabi.app.evidence.service;

import java.util.List;

import com.alabi.app.evidence.entity.IslamicBibleDTO;

public interface IslamicBibleService {
	
	void createIslamicBible(IslamicBibleDTO islamicBibleDTO);
	List <IslamicBibleDTO> readIslamicBible();
	void updateIslamicBible(IslamicBibleDTO islamicBibleDTO);
	void deleteIslamicBibleById(Integer id);
	IslamicBibleDTO searchById(Integer id);
	List <IslamicBibleDTO> findAll(String keyword);
}
