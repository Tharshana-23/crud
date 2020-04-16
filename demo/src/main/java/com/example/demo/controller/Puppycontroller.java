package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class Puppycontroller {

	@GetMapping("/puppy")
	public String redirectionpuppy(Model model) {
		String welcome_message="Love u puppy";
		model.addAttribute("puppy", welcome_message);
		List<String> letters=Arrays.asList("1","2","3","4");
		model.addAttribute("letter" , letters);
		return "welcome";
	}
}
