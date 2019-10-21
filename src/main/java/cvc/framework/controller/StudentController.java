package cvc.framework.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cvc.framework.entity.Student;
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
		student.setStdelete(0);
		student.setStcreatetime(new Date());
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.addStu(student);
		return result;
	}
	//批量添加学员
	@RequestMapping(value="/addManySt",method=RequestMethod.POST)
	@ResponseBody
	public RestResult addManySt(@RequestParam(value = "file", required = false) MultipartFile file)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.addManySt(file);
		return result;
	}
}
