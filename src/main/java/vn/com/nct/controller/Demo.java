package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.base.PasswordCryptService;
import vn.com.nct.base.TimerService;
import vn.com.nct.model.Message;
import vn.com.nct.model.Roles;
import vn.com.nct.model.UserInfo;
import vn.com.nct.model.Users;
import vn.com.nct.model.response.RoleResponse;
import vn.com.nct.model.response.UserInfoResponse;
import vn.com.nct.model.response.UserResponse;
import vn.com.nct.service.objectservice.ObjectService;

@Controller
public class Demo {
	
//	@Autowired
//	private TimerService timer;
//	
//	@Autowired
//	private PasswordCryptService pwCrypt;
//	
//	@Autowired
//	@Qualifier(value = "userService")
//	private ObjectService<Users,UserResponse> userService;
//	
//	@Autowired
//	@Qualifier(value = "userInfoService")
//	private ObjectService<UserInfo,UserInfoResponse> userInfoService;
//	
//	@Autowired
//	@Qualifier("roleService")
//	private ObjectService<Roles,RoleResponse> roleService;
//	
//	@Autowired
//	@Qualifier("publisher")
//	private MqttClient publisher;
//	
//	@RequestMapping(value="demo", method = RequestMethod.GET)
//	public ModelAndView demo(){
//	
//		//init role
//		Roles admin = new Roles(0,"ROLE_ADMIN");
//		
//		List<Roles> lis_role = new ArrayList<>();
//		lis_role.add(admin);
//		
//		roleService.saveE(admin);
//		
//		//admin_info
//		UserInfo ui = new UserInfo();
//		ui.setId(0);
//		ui.setAddress("secret");
//		ui.setDate_of_birth("30/12/1995");
//		ui.setDeleted(0);
//		ui.setEmail("tienvn3012@gmail.com");
//		ui.setFullname("Vu Ngoc Tien");
//		ui.setGender(true);
//		ui.setLevel(0);
//		ui.setPhone("0123456789");
//		
//		UserInfo u = userInfoService.saveE(ui);
//		
//		//admin
//		Users admin_account = new Users();
//		admin_account.setId(0);
//		admin_account.setActive(true);
//		admin_account.setCreate_time(timer.getCurrentTime());
//		admin_account.setCreate_to(false);
//		admin_account.setDeleted(0);
//		admin_account.setUsername("admin");
//		admin_account.setPassword(pwCrypt.encryptPassword("admin"));
//		admin_account.setRole(roleService.getOneById(1));
//		admin_account.setInfo(u);
//		
//		Users ad = userService.saveE(admin_account);
//		
//		System.out.println(ad.getId());
//		System.out.println(ad.getPassword());
//		
//		return new ModelAndView("demo");
//	}
//	
//	@RequestMapping(value = "demop", method = RequestMethod.GET)
//	public ModelAndView dm(){
//		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
//		System.out.println(encoder.encodePassword("nct_laboratory", null));
////		System.out.println(Boolean.parseBoolean("dsadfgbx"));
//		return new ModelAndView("demo");
//	}
//
//	@RequestMapping(value = "demo2", method = RequestMethod.GET)
//	public ModelAndView demo2(){
//		return new ModelAndView("demo2");
//	}
//	
//	@RequestMapping(value = "demo2/led", method = RequestMethod.POST)
//	public void led(){
//		System.out.println("here");
//		try {
//			publisher.publish("nct_control", ("led").getBytes(),2,true);
//		} catch (MqttPersistenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MqttException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@MessageMapping("/control_app")
//	@SendTo("/topic/control")
//	public Message responseMessage(String mes){
//		System.out.println("here");
//		System.out.println(mes);
//		return new Message("Received !");
//	}
//	
	
}
