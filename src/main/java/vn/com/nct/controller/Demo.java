package vn.com.nct.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.model.Message;

@Controller
public class Demo {
	
	@RequestMapping(value="demo", method = RequestMethod.GET)
	public ModelAndView demo(){
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
