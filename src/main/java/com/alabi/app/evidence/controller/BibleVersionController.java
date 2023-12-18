package com.alabi.app.evidence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alabi.app.evidence.entity.BibleVersion;
import com.alabi.app.evidence.entity.BibleVersionDTO;
import com.alabi.app.evidence.service.BibleVersionService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BibleVersionController {

	@Autowired
	private final BibleVersionService bibleVersionService;
	
	@GetMapping("/bibleVersion/show/form")
	public String showBibleVersionForm(Model model) {
		model.addAttribute("bibleVersion", new BibleVersion());
		return "bibleVersion-form";
	}
	
	@PostMapping("/bibleVersion/create")
	public String create(BibleVersionDTO BibleVersionDTO, RedirectAttributes redirectAttributes) {
		String successMessage = "";
		String errorMessage = "";
		Integer id = BibleVersionDTO.id();
		try {
		bibleVersionService.create(BibleVersionDTO);
		if(id != null) {
			successMessage = "Bible Version Edited Successfully!";
		}else {
		successMessage = "Bible Version Created Successfully!";
		}
		successMessage = "BibleVersion created Successfully!";
		}catch(DataIntegrityViolationException e) {
			errorMessage = "BibleVersion must be unique!";
		}
		redirectAttributes.addFlashAttribute("errorMessage", errorMessage);
		redirectAttributes.addFlashAttribute("successMessage", successMessage);
		return "redirect:/bibleVersion/list";
	}
	
	@GetMapping("/bibleVersion/list")
	public String list(Model model) {
		model.addAttribute("bibleVersionsList", bibleVersionService.read());
		return "bibleVersions-page";
	}
	
	@GetMapping("/bibleVersion/update")
	public String updateById(@RequestParam("id") Integer id, Model model) throws Exception {
		model.addAttribute("bibleVersion", bibleVersionService.findById(id));
		return "bibleVersion-form";
	}
	
	@GetMapping("/bibleVersion/delete")
	public String deleteById(@RequestParam("id") Integer id) throws Exception {
		bibleVersionService.deleteById(id);
		return "redirect:/bibleVersion/list";
	}
}
