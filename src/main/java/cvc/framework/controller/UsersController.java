package cvc.framework.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cvc.framework.result.RestMessage;
import cvc.framework.result.RestResult;
import cvc.framework.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {

	
	@Autowired
	private UsersService service;
	
	
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public RestResult getAllUsers()
	{
		System.out.println(service);
		RestResult result=new RestResult();
		result.state=0;
		result.error="";
		result.message=new RestMessage();
		result.message.data=service.getAllUsers();
		return result;
	}
	
	public static void main(String[] args) {
		UsersController c=new UsersController();
		c.getAllUsers();
	}
}
