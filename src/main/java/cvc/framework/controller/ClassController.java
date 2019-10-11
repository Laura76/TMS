package cvc.framework.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	//查询某些课-根据班级名称、某个具体类别
	@RequestMapping(value="/searchClass",method=RequestMethod.GET)
	@ResponseBody
	public RestResult searchClass(String clname,String caname)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchClass(clname,caname);
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
	//添加班级
	@RequestMapping(value="/addClass",method=RequestMethod.POST)
	@ResponseBody
	public RestResult checkUser(@RequestBody Classes classes)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.addClass(classes);
		return result;
	}
	//今日有课
	@RequestMapping(value="/searchTodayClass",method=RequestMethod.GET)
	@ResponseBody
	public RestResult searchTodayClass(String todayTime)
	{
		RestResult result=new RestResult();
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		Date date=null;
		try {    
	           date = format1.parse(todayTime);   
		} catch (ParseException e) {    
	           e.printStackTrace();    
		}
		int[] weekDays = {0, 1, 2,3,4, 5, 6};
        Calendar calendar=Calendar.getInstance();
        int cycle=weekDays[calendar.get(Calendar.DAY_OF_WEEK)-1];
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchTodayClass(date,cycle);
		return result;
	}	
}
