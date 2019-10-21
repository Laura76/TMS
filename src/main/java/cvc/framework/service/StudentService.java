package cvc.framework.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvc.framework.entity.Student;
import cvc.framework.mapper.IStudentMapper;

@Service
public class StudentService 
{

	@Autowired
	private IStudentMapper mapper;
	
	public List<Student> searchAllStu(){
		return mapper.searchAllStu();
	}
}
