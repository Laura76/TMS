package cvc.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cvc.framework.entity.Classes;
import cvc.framework.result.RestMessage;
import cvc.framework.result.RestResult;
import cvc.framework.service.ClassService;

@Controller
public class ClassController {

	
	@Autowired
	private ClassService service;
	//跳转到班级管理页面
	@RequestMapping("/tmsclass")
	public String classPage() {
		return "class";
	}
	//查询某些课-根据班级名称、某个具体类别、教师姓名
	@RequestMapping(value="/searchClass",method=RequestMethod.POST)
	@ResponseBody
	public RestResult searchClass(@RequestBody Classes classes)
	{
		RestResult result=new RestResult();
		String clname=classes.getClname();
		String caname=classes.getCaname();
		String teacher=classes.getTeacher();
		System.out.println(caname+"s");
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchClass(clname,caname,teacher);
		return result;
	}
	//查询某些课-根据班级名称、所有类别、教师姓名
	@RequestMapping(value="/searchAllClass",method=RequestMethod.GET)
	@ResponseBody
	public RestResult searchAllClass(String clname,String teacher) {
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchAllClass(clname,teacher);
		return result;
	}
}
