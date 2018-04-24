package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.constant.Constant;
import vn.com.nct.model.Frame;
import vn.com.nct.model.Layout;
import vn.com.nct.model.response.BlockPropertiesResponse;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.model.response.ModelProperties;
import vn.com.nct.model.response.ModelReferenceProperties;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.PropertiesResponse;
import vn.com.nct.service.objectservice.ObjectService;

@RestController
public class FrameController extends LayoutController{
	
	@Autowired
	private ObjectService<Frame, FrameResponse> frameService;
	
	private List<ModelProperties> display = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;

		{
			add(new ModelProperties("available_frame.image", "img",null,null));
			add(new ModelProperties("available_frame.id", "int",null,"Frame number"));
			add(new ModelProperties("time_begin", "String","calendar","Create at"));
			add(new ModelProperties("plant.plant_name", "String","leaf","Plant"));
			add(new ModelProperties("available_frame.status", "boolean","cogs","Status"));
			add(new ModelProperties("days", "String","clock-o","Days"));
		}
	};
	
	private List<ModelProperties> actions = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;

		{
			add(new ModelProperties("control", "String","gamepad","Control"));
			add(new ModelProperties("statistic","String","bar-chart-o","Statistic"));
		}
	};
	
	
	@RequestMapping(value = "manager/frame", method = RequestMethod.GET)
	public ModelAndView framePage(){
		clear_style();
		set_other_layout("content", "../block_manage.jsp");
		this.more_css.add(new Layout("manager-style", "/GHServer/resources/css/manager/manager.css"));
		this.more_css.add(new Layout("manager-style", "/GHServer/resources/css/manager/block_manage.css"));
		this.more_js.add(new Layout("manager", "/GHServer/resources/js/manager/manager.js"));
		this.more_js.add(new Layout("manager", "/GHServer/resources/js/manager/frame_manager.js"));
		
		ModelAndView model = this.layout();
		return model;
	}
	
	
	@RequestMapping(value = "manager/frame/{page}", method = RequestMethod.GET)
	public ResponseEntity<Page<FrameResponse>> getFrameByPage(@PathVariable int page,
			@RequestParam(value = "row", required = true)int row){
		
		Page<FrameResponse> p = frameService.getPage(page, row);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "manager/frame/properties", method = RequestMethod.GET)
	public ResponseEntity<PropertiesResponse> getUserProperties(){
		
		BlockPropertiesResponse p = new BlockPropertiesResponse();
		p.setName("frame");
		p.setBlock(2);
		p.setBase_url("/GHServer/manager/frame");
		p.setLink_url("manage/frame");
		p.setTotal_records(frameService.countAll());
		p.setModel_properties(Constant.frame_properties);
		p.setModel_properties_filter(null);
		
		p.setActions(actions);
		p.setDisplay(display);
		
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("plant", Constant.plant_properties));
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("device_control", Constant.device_properties));
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("device_colect", Constant.device_properties));
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("available_frame", Constant.available_frame_properties));
		
		return new ResponseEntity<PropertiesResponse>(p, HttpStatus.OK);
	}
}
