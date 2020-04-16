package com.example.demo.controller;






import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Repository.Idogrepo;
import com.example.demo.model.Dog;

@Controller
@RequestMapping("")
public class Dogcontroller {
	
@Autowired
Idogrepo idrepo;

	@GetMapping("/signup")
	public String showsignup_page(Dog dog) {
		
		return "signup";
	}
	//
	@PostMapping("/adddog")
	public String showadddog(@Valid Dog dog, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "signup";
		}
		idrepo.save(dog);
		model.addAttribute("dog", idrepo.findAll());
		return "adddog";
		
	}
	//delete function
	@GetMapping("/delete/{id}")
	
	public String deletedog(@PathVariable("id") Long id, Model model ) {
		Dog dog = idrepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		idrepo.delete(dog);
		model.addAttribute("dog", idrepo.findAll());
		return "adddog";
	}
	
	//edit
	@GetMapping("/edit/{id}")
	public String editdog(@PathVariable("id") Long id, Model model ) {
		Dog dog = idrepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		
		model.addAttribute("dog", dog);
		return "updatedog";
					
	
	}
	
	@PostMapping("/update/{id}")
	public String showupdated(@PathVariable("id") Long id,@Valid Dog dog, BindingResult result,Model model) {
		if(result.hasErrors()) {
		dog.setId(id);
		return "updatedog";
		}
			
			
		
		idrepo.save(dog);
		model.addAttribute("dog", idrepo.findAll());
		return "adddog";
		
	}
	
}

	
	