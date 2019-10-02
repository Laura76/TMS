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
	
	@RequestMapping("/tmsclass")
	public String classPage() {
		return "class";
	}
	
	@RequestMapping(value="/searchClass",method=RequestMethod.POST)
	@ResponseBody
	public RestResult checkUser(@RequestBody Classes classes)
	{
		RestResult result=new RestResult();
		String clname=classes.getClname();
		String caname=classes.getCaname();
		String teacher=classes.getTeacher();
		if(caname=="") {
		}
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchClass(clname,caname,teacher);
		return result;
	}
	
}
