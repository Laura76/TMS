package cvc.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
	@RequestMapping("/tmsteacher")
	public String login() {
		return "teacher";
	}
	
}
