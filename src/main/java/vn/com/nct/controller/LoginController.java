package vn.com.nct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.model.Layout;


@RestController
public class LoginController extends LayoutController{
	
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView login(){
		clear_style();
		set_other_layout("content", "../login.jsp");
		this.more_css.add(new Layout("login_style", "/GHServer/resources/css/login/login.css"));
		
		ModelAndView model = layout();
	
		return model;
	}
	
}
