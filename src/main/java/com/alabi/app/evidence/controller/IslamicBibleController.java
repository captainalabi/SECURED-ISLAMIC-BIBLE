package com.alabi.app.evidence.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alabi.app.evidence.entity.BibleBookDTO;
import com.alabi.app.evidence.entity.IslamicBible;
import com.alabi.app.evidence.entity.IslamicBibleDTO;
import com.alabi.app.evidence.service.BibleBookService;
import com.alabi.app.evidence.service.BibleVersionService;
import com.alabi.app.evidence.service.IslamicBibleService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IslamicBibleController {

	@Autowired
	private IslamicBibleService islamicBibleService;
	@Autowired
	private BibleBookService bookService;
	@Autowired
	private BibleVersionService versionService;

	@GetMapping("/")
	public String homePage(Model model, @Param("keyword") String keyword) {
		model.addAttribute("listAllIslamicBible", islamicBibleService.findAll(keyword));
		return "index";
	}
	
	@GetMapping("/home")
	public String indexPage(Model model, @Param("keyword") String keyword) {
		model.addAttribute("listAllIslamicBible", islamicBibleService.findAll(keyword));
		return "index";
	}
	
	@GetMapping("/show-create-islamicBibleForm")
	public String showCreateIslamicBibleForm(Model model) {	
		model.addAttribute("booksList", bookService.read());
		model.addAttribute("versionsList", versionService.read());
		model.addAttribute("islamicBibleDTO", new IslamicBible());
		return "create-islamicBible";
	}
	
//	@GetMapping("/listAllIslamicBible")
//	public String listAllIslamicBible(Model model, @Param("keyword") String keyword) {		
//		model.addAttribute("listAllIslamicBible", islamicBibleService.findAll(keyword));
//		return "listAllIslamicBible";
//	}
	
	@GetMapping("/getCreateIslamicBibleForm")
	public String getCreateIslamicBibleForm(Model model) {	
		List <BibleBookDTO> booksList = bookService.read();
		model.addAttribute("booksList", booksList);
		model.addAttribute("islamicBible", new IslamicBible());
		return "create-islamicBible";
	}
	
	@PostMapping("/createIslamicBible")
	public String createIslamicBible(Model model, IslamicBibleDTO islamicBibleDTO,
			RedirectAttributes redirectAttributes) {
		String errorMessage = "";
		String successMessage = "";
		Integer id = islamicBibleDTO.id();
		try {
				islamicBibleService.createIslamicBible(islamicBibleDTO);
				
				if(id != null) {
					successMessage = "Entry Successfully Edited!";
				}else {
					successMessage = "Entry Successfully Created!";
				}
		}catch(DataIntegrityViolationException e) {
			errorMessage = "Duplicate entry detected! Explanations must be unique";
		}
		redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
		redirectAttributes.addFlashAttribute("successMessage", successMessage);
		model.addAttribute("listAllIslamicBible", islamicBibleService.readIslamicBible());
		return "redirect:/home";
	}
	
	@GetMapping("/updateIslamicBible")
	public ModelAndView updateIslamicBible(@RequestParam Integer id, Model model){
		model.addAttribute("versionsList", versionService.read());
		model.addAttribute("booksList", bookService.read());
		ModelAndView mav = new ModelAndView("create-islamicBible");
		IslamicBibleDTO islamicBibleDTO = islamicBibleService.searchById(id);
		mav.addObject(islamicBibleDTO);
		return mav;
	}
	
	@GetMapping("/deleteIslamicBible")
	public String deleteIslamicBible(@RequestParam Integer id,
			RedirectAttributes redirectAttributes){
		islamicBibleService.deleteIslamicBibleById(id);	
		redirectAttributes.addFlashAttribute("deleteMessage", "Entry Successfully Deleted!");
		return "redirect:/home";
	}
}

