package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.constant.Constant;

@RestController
public class UserController extends LayoutController{
	
	private List<String> display_left = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
		add("avatar");
		add("info.fullname");
		add("username");
		add("info.date_of_birth");
		
	}};
	
	private List<String> display_mid = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
		add("role.role");	
	}};
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ModelAndView userPage(){
		
		
		ModelAndView model = this.layout();
		model.addObject("properties", Constant.user_properties);
		model.addObject("info", Constant.info_properties);
		model.addObject("role", Constant.role_properties);
		model.addObject("display_left", display_left);
		model.addObject("display_mid", display_mid);
		return model;
	}
	
}
