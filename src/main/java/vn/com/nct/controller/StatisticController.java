package vn.com.nct.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.model.Frame;
import vn.com.nct.model.FrameDataColection;
import vn.com.nct.model.Layout;
import vn.com.nct.model.response.FrameDataCollectionResponse;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.model.response.Page;
import vn.com.nct.service.objectservice.ObjectService;

@RestController
public class StatisticController extends LayoutController{
	
	@Autowired
	private ObjectService<FrameDataColection, FrameDataCollectionResponse> frameDataCollectionService;
	
	@Autowired
	private ObjectService<Frame, FrameResponse> frameService;
	
	@RequestMapping(value = "manager/frame/{id}/statistic", method = RequestMethod.GET)
	public ModelAndView getStatisticPage(@PathVariable int id){
		this.clear_style();
		this.more_css.add(new Layout("css", "/GHServer/resources/css/statistic/statistic.css"));
		this.more_js.add(new Layout("barjs", "/GHServer/resources/js/statistic/bar-chart/bar-chart.js"));
		this.more_js.add(new Layout("linejs", "/GHServer/resources/js/statistic/line-chart/line-chart.js"));
		this.more_js.add(new Layout("statisticjs", "/GHServer/resources/js/statistic/statistic.js"));
		
		this.set_other_layout("content", "../statistic.jsp");
		
		Frame frame = frameService.getOneById(id);
		
		ModelAndView model = this.layout();
		model.addObject("topic","nct_collect_"+frame.getDevice_colect().getId());
		model.addObject("frameid", id);
		
		return model;
	}
	
	@RequestMapping(value = "manager/frame/{id}/statistic/data/{page}", method = RequestMethod.GET)
	public ResponseEntity<Page<FrameDataCollectionResponse>> getDataCollection(@PathVariable int id, 
			@PathVariable int page,@RequestParam("row") int row){
		
		Page<FrameDataCollectionResponse> p = frameDataCollectionService.getPageBy(page, row, 
				"frame.id;"+id+";=;int");
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
}
