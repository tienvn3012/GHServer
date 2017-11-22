package vn.com.nct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController extends LayoutController{
	
	@RequestMapping(value = "user", method = RequestMethod.GET)
	public ModelAndView userPage(){
		
		
		ModelAndView model = this.layout();
		return model;
	}
	
}
