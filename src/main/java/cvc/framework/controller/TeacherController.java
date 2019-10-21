package cvc.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cvc.framework.entity.Teacher;
import cvc.framework.result.RestMessage;
import cvc.framework.result.RestResult;
import cvc.framework.service.TeacherService;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService service;
	//跳转到教师管理页面
	@RequestMapping("/tmsteacher")
	public String login() {
		return "teacher";
	}
	//添加教师
	@RequestMapping(value="/addTe",method=RequestMethod.POST)
	@ResponseBody
	public RestResult addTe(@RequestBody Teacher teacher)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.addTe(teacher);
		return result;
	}
	//查询所有教师
	@RequestMapping(value="/searchAllTe",method=RequestMethod.GET)
	@ResponseBody
	public RestResult searchAllTe() {
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchAllTe();
		return result;
	}
	//导出简历--获取某教师的详细信息
	@RequestMapping(value="/downloadResume",method=RequestMethod.GET)
	@ResponseBody
	public RestResult downloadResume(String teid) {
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.downloadResume(teid);
		return result;
	}
	
}
