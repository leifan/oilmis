package com.mltech.brite.controller;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequiresAuthentication
	@RequestMapping("index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@RequiresAuthentication
	@RequestMapping("oilCanListPage")
	public ModelAndView oilCanListPage(){
		ModelAndView modelAndView = new ModelAndView("oilCanList");
		return modelAndView;
	}
	
	@RequiresAuthentication
	@RequestMapping("districtAndDepartment")
	public ModelAndView districtAndDepartment(){
		ModelAndView modelAndView = new ModelAndView("districtAndDepartment");
		return modelAndView;
	}
	
	@RequiresAuthentication
	@RequestMapping("oilTypeAndProductPage")
	public ModelAndView oilTypeAndProductPage(){
		ModelAndView modelAndView = new ModelAndView("oilTypeAndProduct");
		return modelAndView;
	}
	
	@RequiresAuthentication
	@RequestMapping("oilStationStaffPage")
	public ModelAndView oilStationStaffPage(){
		ModelAndView modelAndView = new ModelAndView("oilStationStaff");
		return modelAndView;
	}
	
	@RequiresAuthentication
	@RequestMapping("userSettingPage")
	public ModelAndView userSettingPage(){
		ModelAndView modelAndView = new ModelAndView("userSettingForm");
		return modelAndView;
	}
	
	@RequestMapping("logininit")
	public ModelAndView loginInit( ){
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping("login/init2")
	@ResponseBody
	public String loginInit2( ){
		return "String";
	}

}
