package pe.marcolopez.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import pe.marcolopez.auth.domain.User;
import pe.marcolopez.auth.service.UserService;

@RequestMapping("/hello")
@Controller
@RequiredArgsConstructor
public class HelloController {

	private final UserService userService;
	
	@GetMapping("/user")
	public User getUser() {
		return userService.getUser("admin");
	}
	
}
