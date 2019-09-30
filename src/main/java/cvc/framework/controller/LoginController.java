package cvc.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/tmslogin")
	public String login() {
		return "login";
	}
	
}
