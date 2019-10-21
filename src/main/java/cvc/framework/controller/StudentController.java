package cvc.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cvc.framework.entity.Student;
import cvc.framework.entity.Teacher;
import cvc.framework.result.RestMessage;
import cvc.framework.result.RestResult;
import cvc.framework.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	//跳转到学员管理页面
	@RequestMapping("/tmsstudent")
	public String login() {
		return "student";
	}
	//查询所有学生
	@RequestMapping(value="/getAllStu",method=RequestMethod.GET)
	@ResponseBody
	public RestResult getAllStu() {
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchAllStu();
		return result;
	}
	//添加学员
	@RequestMapping(value="/addSt",method=RequestMethod.POST)
	@ResponseBody
	public RestResult addSt(@RequestBody Student student)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
//		result.message.data=service.addSt(teacher);
		return result;
	}
}
