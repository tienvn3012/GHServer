package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.model.Layout;

public class LayoutController {
	
	protected List<Layout> lis_layout = new ArrayList<>();
	protected List<Layout> more_css   = new ArrayList<>();
	protected List<Layout> more_js 	  = new ArrayList<>();
	protected int row = 5;
	protected int total_page = 0;
	protected int total_records = 0;
	protected int page_number = 1;
	
	@PostConstruct
	public void init_layout(){
		set_layout();
	}
	
	protected ModelAndView layout(){
		ModelAndView model = new ModelAndView("layout/main");
		
		for (int i = 0; i < lis_layout.size(); i++) {
			model.addObject(lis_layout.get(i).getLayout(), lis_layout.get(i).getPath());
		}
		
		model.addObject("more_css",more_css);
		model.addObject("more_js", more_js);
		
		return model;
	}
	
	public void set_layout(){
		lis_layout.add(new Layout("head", "head.jsp"));
		lis_layout.add(new Layout("head_loadmore", "head_loadmore.jsp"));
		lis_layout.add(new Layout("topbar", "topbar.jsp"));
		lis_layout.add(new Layout("sidebar", "sidebar.jsp"));
		lis_layout.add(new Layout("content", "content.jsp"));
		lis_layout.add(new Layout("footer", "footer.jsp"));
	}
	
	private int find_index_layout(String layout){
		switch (layout){
			case "head" :
				return 0;
			case "head_loadmore" :
				return 1;
			case "topbar" :
				return 2;
			case "sidebar" :
				return 3;
			case "content" :
				return 4;
			case "footer" :
				return 5;
			default :
				return 1000;
		}
	}
	
	protected void set_other_layout(String part, String path){
		int index = this.find_index_layout(part);
		if(index != 1000){
			this.lis_layout.get(index).setPath(path);
		}
	}
	
	protected void clear_style(){
		more_css.clear();
		more_js.clear();
	}
	
	protected void slove_page_info() {
		this.total_page = (total_records%row == 0 ? total_records/row:total_records/row + 1);
	}
}
