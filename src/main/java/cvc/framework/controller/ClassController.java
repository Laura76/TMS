package cvc.framework.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cvc.framework.entity.ClassStu;
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
	//学员管理跳转controller
	@RequestMapping("/searchClassStuJump")
	public String searchClassStuJump( Model model,String clid) {
	        model.addAttribute("clid", clid);
	        return "classStuManage.html";
	 }   
	//学员管理-查询该节课的所有学员信息
	@RequestMapping(value="/searchClassStu",method=RequestMethod.GET)
	@ResponseBody
	public RestResult searchClassStu(String clid)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchClassStu(clid);
		return result;
	}
	//获取系统上面所有的学员信息-并判断是否在该班级
	@RequestMapping(value="/searchAllStu",method=RequestMethod.GET)
	@ResponseBody
	public RestResult searchAllStu(String clid)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.searchAllStu(clid);
		return result;
	}
	//编辑学员-将学员从该课批量删除，将某些学员批量添加到该课程--批量以后做，先一条一条添加 
	@RequestMapping(value="/addStu",method=RequestMethod.POST)
	@ResponseBody
	public RestResult addStu(@RequestBody ClassStu classStu)
	{
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		String clid=classStu.getClid();
		//添加学员
		for(String str:classStu.getAddStu()) {
			if(service.addStu(new ClassStu(clid,str))==0) {
				result.message.data=0;
				return result;
			};
		}
		//删除学员
		for(String str:classStu.getDeleteStu()) {
			if(service.deleteStu(clid,str)==0) {
				result.message.data=0;
				return result;
			};
		}
		result.message.data=1;
		return result;
	}
	//学员签到跳转controller
	@RequestMapping("/stuSignIn")
	public String stuSignIn( Model model,String clid) {
	        model.addAttribute("clid", clid);
	        return "classSignIn.html";
	 }   
	//查询某门课程的所有学员的签到情况--没有记录的签到情况为无
	@RequestMapping(value="/searchStuSignIn",method=RequestMethod.GET)
	@ResponseBody
	public RestResult searchStuSignIn(String clid,String sitime)
	{
		RestResult result=new RestResult();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
		try {
			Date date=sdf.parse(sitime);
			result.state=0;
			result.error="";
			result.message=new RestMessage();
			result.message.data=service.searchStuSignIn(clid,date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
