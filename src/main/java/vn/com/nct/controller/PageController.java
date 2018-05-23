package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.model.Layout;
import vn.com.nct.model.response.ModelProperties;

@RestController
public class PageController extends LayoutController{

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public ModelAndView getHomePage(){
		this.clear_style();
		this.set_other_layout("content", "../home.jsp");
		this.more_css.add(new Layout("control_style", "/GHServer/resources/css/page/home.css"));
		this.more_js.add(new Layout("control_js", "/GHServer/resources/js/page/home.js"));
		
		ModelAndView model = this.layout();
		
		List<ModelProperties> items = new ArrayList<>();
		
		items.add(new ModelProperties("/GHServer/home", null, "home", "Home"));
		items.add(new ModelProperties("/GHServer/manage", null, "tasks", "Manage"));
		items.add(new ModelProperties("/GHServer/manager/frame/1/statistic", null, "bar-chart", "Statistic"));
		items.add(new ModelProperties("/GHServer/manager/frame/1/control", null, "wifi", "Control"));
		
		model.addObject("items", items);
		
		return model;
	}
	
	@RequestMapping(value = "manage", method = RequestMethod.GET)
	public ModelAndView getManagePage(){
		this.clear_style();
		this.set_other_layout("content", "../home.jsp");
		this.more_css.add(new Layout("control_style", "/GHServer/resources/css/page/home.css"));
		this.more_js.add(new Layout("control_js", "/GHServer/resources/js/page/home.js"));
		
		ModelAndView model = this.layout();
		
		List<ModelProperties> items = new ArrayList<>();
		
		items.add(new ModelProperties("/GHServer/manager/log", null, "cogs", "Log"));
		items.add(new ModelProperties("/GHServer/manager/user", null, "users", "Users"));
		items.add(new ModelProperties("/GHServer/manager/frame", null, "leaf", "Frame"));
		
		model.addObject("items", items);
		
		return model;
	}
	
}
