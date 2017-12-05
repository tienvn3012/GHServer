package vn.com.nct.service.controlservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import vn.com.nct.constant.Constant;
import vn.com.nct.model.Frame;
import vn.com.nct.model.Plants;
import vn.com.nct.service.PublishService;
import vn.com.nct.service.objectservice.ObjectService;

@Service
@Scope("prototype")
public class AutomaticControlServiceIplm implements AutomaticControlService{
	
	private int id;
	private int harvest_time;
	private String on;
	private String off;
	
	@Autowired
	private ObjectService<Frame> frameService;
	
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
	public PublishService control(String type, double time, int did, int harvest_time) {
		PublishService control = this.identifyControl(type);
		control.setDelay_time(time);
		control.setDid(did);
		control.setMessage_on(this.on);
		control.setMessage_off(this.off);
		control.setStop_time(harvest_time);
		control.start();
		
		return control;
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

	@Override
	public void plantAnalysis(int id) {
		this.id = id;
		Frame frame = frameService.getOneByCondition("device_control.id;"+id+";=;int");
		Plants plant = frame.getPlant();
		this.harvest_time = plant.getPlant_info().getTime_harvest();
		this.lightAnalysis(plant.getPlant_info().getLight_time());
		
		
	}

	@Override
	public void trackParamsAnalysis(String msg, String topic) {
		// from topic -> id
		String[] msgSplit = msg.split(Constant.SPLIT_PATTERN);
		temperatureAnalysis(msgSplit[1]);
		humidityAnalysis(msgSplit[2]);
		co2Analysis(msgSplit[3]);
		phAnalysis(msgSplit[4]);

	}
	
	private void lightAnalysis(String info){
		String[] days = info.split(Constant.SPLIT_PATTERN_LEVEL2);
		if(days.length == 1){
			String[] split = info.split(Constant.SPLIT_PATTERN);
			if(0 == Integer.parseInt(split[2])){
				this.control("led", Double.parseDouble(split[1]), id, this.harvest_time+30);
			}
		}else{
			List<Thread> lis = new ArrayList<>();
			for (int i = 0; i < days.length; i++) {
				String[] split = info.split(Constant.SPLIT_PATTERN);
				if(0 != Integer.parseInt(split[2])){
					lis.add(this.control("led", Double.parseDouble(split[1]), id, Integer.parseInt(split[2])));
				}else {
					lis.add(this.control("led", Double.parseDouble(split[1]), id, 30));
				}
			}
			for (int i = 0; i < lis.size(); i++) {
				try {
					lis.get(i).join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}
	
	private String humidityAnalysis(String info){
		return null;
	}
	
	private String co2Analysis(String info){
		return null;
	}
	
	private String phAnalysis(String info){
		return null;
	}

	private String temperatureAnalysis(String info){
		return null;
	}
}
