package com.modestack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modestack.common.ServiceDependencyBean;
import com.modestack.model.User;

@Controller
public class UserController extends ServiceDependencyBean {

	
	@RequestMapping(value="/register" ,method= {RequestMethod.GET,RequestMethod.POST},consumes= {"application/json"} )
	@ResponseBody public String registerUser(@RequestBody User user) {
		System.out.println("user save"+user.toString());
		
	    userService.saveUser(user);
	return "new user created";
	}
	
	@RequestMapping(value="getUser",method= {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody public User getUserById(@RequestParam String userId) {
		User user=new User();
	
		return null;
	}
	
	@RequestMapping(value="/getUserData" ,method= {RequestMethod.GET,RequestMethod.POST} ,produces= {"application/json"})
	@ResponseBody public User getUserDetails() {
		
		return null;
	}
}
