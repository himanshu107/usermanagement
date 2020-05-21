package com.modestack.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.modestack.common.ServiceDependencyBean;

@Controller
public class HomeController extends ServiceDependencyBean {

	
	@RequestMapping("/")
	public ModelAndView modeStackHome() {
		System.out.println("request comming");
	ModelAndView mav= new  ModelAndView();
	mav.setViewName("static/front/homeindex.html");
	return mav;
	}
	
	
	
	@RequestMapping(value="/home",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("static/front/home.html");
		return modelAndView;
	}
	
	@RequestMapping(value="/logins",method= {RequestMethod.POST})
	@ResponseBody public String userLogin(@RequestParam String email ,@RequestParam String password) {
		
		String message =userService.userLogin(email,password);
		return message;
	}

	
	@RequestMapping(value="/adminDashboard",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView adminDashboard(HttpServletRequest request){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("static/admin/admindashboard.html");
		return modelAndView;
	}
	           
	@RequestMapping(value="/adminDashboardHome",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView adminDashboardPage(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("static/admin/admindashboardpage.html");
		return modelAndView;
	}
	
	@RequestMapping(value="/superadminredirect",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody String superadminredirect(HttpServletRequest request){
		
		return "./adminDashboard";
	}

	
	   
	
	
	
}
