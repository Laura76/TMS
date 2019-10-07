package cvc.framework.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvc.framework.entity.Classes;
import cvc.framework.entity.User;
import cvc.framework.mapper.IClassMapper;

@Service
public class ClassService 
{

	@Autowired
	private IClassMapper mapper;
	
	public List<User> searchClass(String clname,String caname,String teacher)
	{
		return mapper.searchClass(clname,caname,teacher);
	}
	
	public List<Classes> searchAllClass(String clname,String teacher)
	{
		return mapper.searchAllClass(clname,teacher);
	}
}
