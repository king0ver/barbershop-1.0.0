package com.yl.barbershop.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yl.barbershop.web.annotation.AuthRequired;
import com.yl.barbershop.web.util.AuthLevel;
import com.yl.barbershop.web.util.Constants;
import com.yl.barbershop.web.util.JsonPackageWrapper;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@AuthRequired(AuthLevel.NONE)
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		
		return "user/login";
	}
	@AuthRequired(AuthLevel.NONE)
	@RequestMapping(value="/existed/{userName}",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody JsonPackageWrapper existed(@PathVariable String userName){
		
		JsonPackageWrapper json = new JsonPackageWrapper();
		
		if(userName.length() > 0 && "admin".equals(userName)){
			
		}else{
			json.setScode(JsonPackageWrapper.S_ERR);
		}
		
		return json;
	}
	
	@AuthRequired(AuthLevel.NONE)
	@RequestMapping(value="/login",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody JsonPackageWrapper login(String userName,String password,HttpServletRequest request){
		
		JsonPackageWrapper json = new JsonPackageWrapper();
		
		if(userName.length() > 0 && "admin".equals(userName)&&"admin".equals(password)){
			request.getSession().setAttribute(Constants.LOGINNAME, userName);
		}else{
			json.setScode(JsonPackageWrapper.S_ERR);
		}
		
		return json;
	}
	
	@AuthRequired
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(){
		
		return "user/index";
	}
}
