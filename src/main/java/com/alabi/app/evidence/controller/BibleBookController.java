package com.alabi.app.evidence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alabi.app.evidence.entity.*;
import com.alabi.app.evidence.service.BibleBookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BibleBookController {

	@Autowired
	private final BibleBookService bibleBookService;
		
	@GetMapping("/bibleBook/show/form")
	public String showBibleBookForm(Model model) {
		model.addAttribute("bibleBook", new BibleBook());
		return "bibleBook-form";
	}
	
	@PostMapping("/bibleBook/create")
	public String create(BibleBookDTO BibleBookDTO, RedirectAttributes redirectAttributes) {
		
		Integer id = BibleBookDTO.id();
		
		String successMessage = "";
		String errorMessage = "";
		try {
		bibleBookService.create(BibleBookDTO);
		if(id != null) {
			successMessage = "Bible Book Edited Successfully!";
		}else {
		successMessage = "Bible Book Created Successfully!";
		}
		}catch(DataIntegrityViolationException e) {
			errorMessage = "BibleBook must be unique!";
		}
		redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
		redirectAttributes.addFlashAttribute("successMessage", successMessage);
		return "redirect:/bibleBook/list";
	}
	
	@GetMapping("/bibleBook/list")
	public String list(Model model) {
		model.addAttribute("bibleBooksList", bibleBookService.read());
		return "bibleBooks-page";
	}
	
	@GetMapping("/bibleBook/update")
	public String updateById(@RequestParam("id") Integer id, Model model) throws Exception {
		model.addAttribute("bibleBook", bibleBookService.findById(id));
		return "bibleBook-form";
	}
	
	@GetMapping("/bibleBook/delete")
	public String deleteById(@RequestParam("id") Integer id) throws Exception {
		bibleBookService.deleteById(id);
		return "redirect:/bibleBook/list";
	}
}
