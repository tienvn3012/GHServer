package vn.com.nct.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
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
import vn.com.nct.service.ObjectService;

@Controller
public class Demo {
	
	@Autowired
	private TimerService timer;
	
	@Autowired
	private PasswordCryptService pwCrypt;
	
	@Autowired
	private ObjectService<Users> userService;
	
	@Autowired
	private ObjectService<UserInfo> userInfoService;
	
	@Autowired
	private ObjectService<Roles> roleService;
	
	@RequestMapping(value="demo", method = RequestMethod.GET)
	public ModelAndView demo(@RequestParam(name = "id")String id,
			@RequestParam(name = "content")String content){
	
		//init role
		Roles admin = new Roles(0,"ROLE_ADMIN");
		
		List<Roles> lis_role = new ArrayList<>();
		lis_role.add(admin);
		
		roleService.saveOrUpdateE(admin);
		
		//admin_info
		UserInfo ui = new UserInfo();
		ui.setId(0);
		ui.setAddress("victoria secret");
		ui.setDate_of_birth("30/12/1995");
		ui.setDeleted(0);
		ui.setEmail("tienvn3012@gmail.com");
		ui.setFullname("Vu Ngoc Tien");
		ui.setGender(true);
		ui.setLevel(0);
		ui.setPhone("0123456789");
		
		UserInfo u = userInfoService.saveOrUpdateE(ui);
		
		
		//admin
		Users admin_account = new Users();
		admin_account.setId(0);
		admin_account.setActive(true);
		admin_account.setCreate_time(timer.getCurrentTime());
		admin_account.setCreate_to(false);
		admin_account.setDeleted(0);
		admin_account.setUsername("admin");
		admin_account.setPassword(pwCrypt.encryptPassword("admin"));
		admin_account.setRole(roleService.getOneById(1));
		admin_account.setInfo(u);
		
		Users ad = userService.saveOrUpdateE(admin_account);
		
		System.out.println(ad.getId());
		System.out.println(ad.getPassword());
		
		return new ModelAndView("demo");
	}
	
	
	@MessageMapping("/control_app")
	@SendTo("/topic/control")
	public Message responseMessage(String mes){
		System.out.println("here");
		System.out.println(mes);
		return new Message("Received !");
	}
	
	
}
