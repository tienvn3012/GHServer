package vn.com.nct.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.model.Layout;

@RestController
public class StatisticController extends LayoutController{
	
	@RequestMapping(value = "statistic", method = RequestMethod.GET)
	public ModelAndView getStatisticPage(){
		this.clear_style();
		this.more_css.add(new Layout("css", "/GHServer/resources/css/statistic/statistic.css"));
		this.more_js.add(new Layout("barjs", "/GHServer/resources/js/statistic/bar-chart/bar-chart.js"));
		this.more_js.add(new Layout("statisticjs", "/GHServer/resources/js/statistic/statistic.js"));
		
		this.set_other_layout("content", "../statistic.jsp");
		
		ModelAndView model = this.layout();
		return model;
	}
	
}
