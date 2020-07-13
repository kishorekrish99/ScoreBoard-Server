package com.scoreboard.BoardAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class SecurityController {
	@GetMapping("/success")
	public String login() {
		return "SuccessFull";
	}
}
