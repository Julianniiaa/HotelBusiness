package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}


	@GetMapping("/gallery")
	public String gallery() {
		return "/gallery";
	}

	@GetMapping("/about")
	public String about() {
		return "/about";
	}

	@GetMapping("/room")
	public String room() {
		return "/room";
	}




}
