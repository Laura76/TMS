package cvc.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	//跳转到学员管理页面
	@RequestMapping("/tmsstudent")
	public String login() {
		return "student";
	}
	
}
