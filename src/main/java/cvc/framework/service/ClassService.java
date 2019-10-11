package cvc.framework.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvc.framework.entity.ClassTime;
import cvc.framework.entity.Classes;
import cvc.framework.mapper.IClassMapper;

@Service
public class ClassService 
{

	@Autowired
	private IClassMapper mapper;
	
	public List<Classes> searchClass(String clname,String caname)
	{
		return mapper.searchClass(clname,caname);
	}
	
	public List<Classes> searchAllClass(String clname,String teacher)
	{
		return mapper.searchAllClass(clname,teacher);
	}
	public int addClass(Classes classes){
		int res=mapper.addClass(classes);
		String clid=classes.getClid();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		for(int i=0;i<classes.getCycles().length;i++) {
			String[] oneDay=classes.getCycles()[i].split(" ");
			Date begintime;
			try {
				begintime = format.parse("2019-01-01 "+oneDay[1]);
				Date endtime = format.parse("2019-01-01 "+oneDay[2]);
				ClassTime classtime=new ClassTime(clid,begintime,endtime,Integer.valueOf(oneDay[0]));
				if(mapper.addClassTime(classtime)==0) {
					return 0;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public List<Classes> searchTodayClass(Date todayTime,int cycle)
	{
		return mapper.searchTodayClass(todayTime,cycle);
	}
}
