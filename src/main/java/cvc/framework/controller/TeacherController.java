package cvc.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {
	//跳转到教师管理页面
	@RequestMapping("/tmsteacher")
	public String login() {
		return "teacher";
	}
	
}
