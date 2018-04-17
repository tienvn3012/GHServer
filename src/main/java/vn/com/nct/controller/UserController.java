package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.base.TimerService;
import vn.com.nct.constant.Constant;
import vn.com.nct.model.Layout;
import vn.com.nct.model.Roles;
import vn.com.nct.model.UserInfo;
import vn.com.nct.model.Users;
import vn.com.nct.model.response.ModelProperties;
import vn.com.nct.model.response.ModelReferenceProperties;
import vn.com.nct.model.response.Page;
import vn.com.nct.model.response.PropertiesResponse;
import vn.com.nct.model.response.TablePropertiesResponse;
import vn.com.nct.model.response.UserInfoResponse;
import vn.com.nct.model.response.UserResponse;
import vn.com.nct.service.objectservice.ObjectService;

@RestController
public class UserController extends LayoutController{
	
	@Autowired
	private ObjectService<Users, UserResponse> userService;
	
	@Autowired
	private ObjectService<UserInfo, UserInfoResponse> userInfoService;
	
	@Autowired
	private TimerService timerService;
	
	private List<ModelProperties> display_left = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("avatar", "img",null));
		add(new ModelProperties("info.fullname", "String",null));
		add(new ModelProperties("username", "String",null));
		add(new ModelProperties("info.date_of_birth", "String",null));
		
	}};
	
	private List<ModelProperties> display_mid = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("null", "null",null));
		add(new ModelProperties("role.role", "String",null));
		add(new ModelProperties("info.email", "String",null));
		add(new ModelProperties("info.phone", "String",null));
	}};
	
	private List<String> display_right = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
	{
		add("delete");
		add("edit");
	}};
	
	@RequestMapping(value = "manager/user", method = RequestMethod.GET)
	public ModelAndView userPage(){
		clear_style();
		set_other_layout("content", "../manager.jsp");
		this.more_css.add(new Layout("manager-style", "/GHServer/resources/css/manager/manager.css"));
		this.more_js.add(new Layout("manager", "/GHServer/resources/js/manager/manager.js"));
		this.more_js.add(new Layout("manager_user", "/GHServer/resources/js/manager/user_manager.js"));
		
		ModelAndView model = this.layout();
		return model;
	}
	
	@RequestMapping(value = "manager/user/{page}", method = RequestMethod.GET)
	public ResponseEntity<Page<UserResponse>> getUserByPage(@PathVariable int page,
			@RequestParam(value = "row", required = true)int row){
		
		Page<UserResponse> p = userService.getPage(page, row);
		
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@RequestMapping(value = "manager/user/add", method = RequestMethod.POST)
	public String addUser(@RequestBody UserResponse user){
		
		UserInfo info = userInfoService.parseToStandar(user.getInfo());
		info = userInfoService.saveE(info);
		
		
		user.setActive(true);
		user.setCreate_by(1);
		user.setCreate_time(timerService.getCurrentTime());
		
		Users u = userService.parseToStandar(user);
		u.setInfo(info);
		u.setRole(new Roles(user.getRole().getId(), user.getRole().getRole()));
		
		userService.saveE(u);
		
		this.total_records+=1;
		
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "manager/user/edit", method = RequestMethod.POST)
	public String editUser(@RequestBody UserResponse user,
			@RequestParam(value = "id", required = true)int id){
		
		Users u = userService.getOneById(id);
		
		
		
		u.setUsername(user.getUsername());
		u.getInfo().setAddress(user.getInfo().getAddress());
		u.getInfo().setDate_of_birth(user.getInfo().getDate_of_birth());
		u.getInfo().setEmail(user.getInfo().getEmail());
		u.getInfo().setFullname(user.getInfo().getFullname());
		u.getInfo().setGender(user.getInfo().isGender());
		u.getInfo().setLevel(user.getInfo().getLevel());
		u.getInfo().setPhone(user.getInfo().getPhone());
		
		u.getRole().setId(user.getRole().getId());
		u.getRole().setRole(user.getRole().getRole());
		
		userInfoService.updateE(u.getInfo());
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "manager/user/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id){
		userService.deleteE(id);
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "manager/user/properties", method = RequestMethod.GET)
	public ResponseEntity<PropertiesResponse> getUserProperties(){
		
		TablePropertiesResponse p = new TablePropertiesResponse();
		p.setName("user");
		p.setBlock(false);
		p.setBase_url("/GHServer/manager/user");
		p.setLink_url("manage/user");
		p.setTotal_records(userService.countAll());
		p.setDisplay_left(display_left);
		p.setDisplay_mid(display_mid);
		p.setDisplay_right(display_right);
		p.setModel_properties(Constant.user_properties);
		p.setModel_properties_filter(Constant.user_properties_filter);
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("info", Constant.info_properties));
		p.getLis_model_reference_properties().add(new ModelReferenceProperties("role", Constant.role_properties));
				
		return new ResponseEntity<PropertiesResponse>(p, HttpStatus.OK);
	}
}
