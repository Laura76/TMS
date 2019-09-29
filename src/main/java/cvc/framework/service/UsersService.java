package cvc.framework.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cvc.framework.entity.User;
import cvc.framework.mapper.IUsersMapper;

@Service
public class UsersService 
{

	@Autowired
	private IUsersMapper mapper;
	
	public List<User> checkUser(String username,String password)
	{
		return mapper.checkUser(username,password);
	}
}
