package cvc.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cvc.framework.entity.User;
import cvc.framework.result.RestMessage;
import cvc.framework.result.RestResult;
import cvc.framework.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	
	@Autowired
	private UsersService service;
	
	
	@RequestMapping(value="/checkUser",method=RequestMethod.POST)
	@ResponseBody
	public RestResult checkUser(@RequestBody User user)
	{
		RestResult result=new RestResult();
		String username=user.getUsername();
		String password=user.getPassword();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.checkUser(username,password).size();
		return result;
	}
}
