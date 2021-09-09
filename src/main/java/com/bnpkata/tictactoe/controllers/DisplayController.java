package com.bnpkata.tictactoe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DisplayController {

	@GetMapping("/display")
	public String display() {
		return "display";
	}
}
