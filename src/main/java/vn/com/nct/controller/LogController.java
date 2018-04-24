package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.constant.Constant;
import vn.com.nct.model.Layout;
import vn.com.nct.model.SystemLogActivity;
import vn.com.nct.model.response.LogResponse;
import vn.com.nct.model.response.ModelProperties;
import vn.com.nct.model.response.ModelReferenceProperties;
import vn.com.nct.model.response.PropertiesResponse;
import vn.com.nct.model.response.TablePropertiesResponse;
import vn.com.nct.service.objectservice.ObjectService;

@RestController
public class LogController extends LayoutController{
	
	@Autowired
	private ObjectService<SystemLogActivity, LogResponse> logService;
	
	private List<ModelProperties> display = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;

		{
			add(new ModelProperties("time", "String",null,"Time"));
			add(new ModelProperties("auto", "boolean",null,"Auto"));
			add(new ModelProperties("statement.title", "String",null,"Action"));
			add(new ModelProperties("notification.notifications", "String",null,"Notification"));
			add(new ModelProperties("users.username", "String",null,"User"));
			add(new ModelProperties("frame.available_frame.id", "int",null,"Frame"));
		}
	};
	
	@RequestMapping(value = "manager/log", method = RequestMethod.GET)
	public ModelAndView userPage(){
		clear_style();
		set_other_layout("content", "../table_manage.jsp");
		this.more_js.add(new Layout("manager", "/GHServer/resources/js/manager/table_manage.js"));
		this.more_js.add(new Layout("log_manager", "/GHServer/resources/js/manager/log_manage.js"));
		
		ModelAndView model = this.layout();
		return model;
	}
	
	@RequestMapping(value = "manager/log/data", method = RequestMethod.GET)
	public ResponseEntity<List<LogResponse>> getLogData(){
		return new ResponseEntity<List<LogResponse>>(logService.parseAll(logService.getAll()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "manager/log/properties", method = RequestMethod.GET)
	public ResponseEntity<PropertiesResponse> getLogProperties(){
		
		TablePropertiesResponse p = new TablePropertiesResponse();
		
		p.setName("log");
		p.setBlock(3);
		p.setDisplay(display);
		p.setModel_properties(Constant.log_properties);
		
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("statement", Constant.statement_properties));
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("notification", Constant.notification_properties));
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("users", Constant.user_properties));
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("frame", Constant.frame_properties));
		
		
		return new ResponseEntity<PropertiesResponse>(p, HttpStatus.OK);
	}
	
}
