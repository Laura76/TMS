package cvc.framework.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvc.framework.entity.Teacher;
import cvc.framework.mapper.ITeacherMapper;

@Service
public class TeacherService 
{

	@Autowired
	private ITeacherMapper mapper;
	
	
	public int addTe(Teacher teacher){
		int res=mapper.addTe(teacher);
		return res;
	}
	public List<Teacher> searchAllTe(){
		return mapper.searchAllTe();
	}
}
