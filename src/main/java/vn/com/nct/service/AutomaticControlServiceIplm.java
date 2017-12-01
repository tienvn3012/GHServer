package vn.com.nct.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nct.constant.Constant;

@Service
public class AutomaticControlServiceIplm implements AutomaticControlService{
	
	private String on;
	private String off;
	
	@Autowired
	private PublishService ledControlService;
	
	@Autowired
	private PublishService heatLedControlService;
	
	@Autowired
	private PublishService fanControlService;
	
	@Autowired
	private PublishService pumpAControlService;
	
	@Autowired
	private PublishService pumpBControlservice;
	
	@Autowired
	private PublishService pumpPHUpControlService;
	
	@Autowired
	private PublishService pumpPHDownControlService;

	@Override
	public void control(String type, double time, int did) {
		PublishService control = this.identifyControl(type);
		control.setDelay_time(time);
		control.setDid(did);
		control.setMessage_on(this.on);
		control.setMessage_off(this.off);
		control.start();
	}
	
	private PublishService identifyControl(String type){
		switch (type){
			case "led" :
				this.on = Constant.LED_ON;
				this.off = Constant.LED_OFF;
				return this.ledControlService;
			case "heat_led" :
				this.on = Constant.HEAT_LED_ON;
				this.off = Constant.HEAT_LED_OFF;
				return this.heatLedControlService;
			case "fan" :
				this.on = Constant.FAN_ON;
				this.off = Constant.FAN_OFF;
				return this.fanControlService;
			case "pumpA" :
				this.on = Constant.PUMP_A_ON;
				this.off = Constant.PUMP_A_OFF;
				return this.pumpAControlService;
			case "pumpB" :
				this.on = Constant.PUMP_B_ON;
				this.off = Constant.PUMP_B_OFF;
				return this.pumpBControlservice;
			case "pumpUp" :
				this.on = Constant.PUMP_UP_ON;
				this.off = Constant.PUMP_UP_OFF;
				return this.pumpPHUpControlService;
			case "pumpDown" :
				this.on = Constant.PUMP_DOWN_ON;
				this.off = Constant.PUMP_UP_OFF;
				return this.pumpPHDownControlService;
			default :
				return null;
		}
	}
	
}
