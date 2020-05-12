package it.formarete.apiserver.presentation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String hello(@RequestParam(name = "who", defaultValue = "world") String who, Model model) {
		model.addAttribute("name", who);
		return "hello";

	}
}
