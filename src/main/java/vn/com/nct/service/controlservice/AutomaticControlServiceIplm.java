package vn.com.nct.service.controlservice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.com.nct.base.TimerService;
import vn.com.nct.constant.Constant;
import vn.com.nct.model.Frame;
import vn.com.nct.service.PublishService;
import vn.com.nct.service.PublishServiceSeconds;
import vn.com.nct.service.objectservice.ObjectService;

@Service
public class AutomaticControlServiceIplm implements AutomaticControlService{
	
	private String on;
	private String off;
	
	private List<Frame> lisFrame = new ArrayList<>();
	
	@Autowired
	private TimerService timer;
	
	@Autowired
	@Qualifier(value = "frameService")
	private ObjectService<Frame,Object> frameService;
	
	@Autowired
	private PublishService ledControlService;
	
	@Autowired
	private PublishService heatLedControlService;
	
	@Autowired
	private PublishService fanControlService;
	
	@Autowired
	private PublishServiceSeconds pumpAControlService;
	
	@Autowired
	private PublishServiceSeconds pumpBControlservice;
	
	@Autowired
	private PublishServiceSeconds pumpPHUpControlService;
	
	@Autowired
	private PublishService pumpPHDownControlService;

	@Override
	public PublishService control(String type, double time, int did, int harvest_time) {
		PublishService control = (PublishService)this.identifyControl(type);
		control.setDelay_time(time);
		control.setDid(did);
		control.setMessage_on(this.on);
		control.setMessage_off(this.off);
		control.setStop_time(harvest_time);
		control.start();
		
		return control;
	}
	
	@Override
	public PublishServiceSeconds controlOneTime(String type, double time, int did) {
		
		PublishServiceSeconds control = (PublishServiceSeconds)this.identifyControl(type);
		control.setDelay_time(time);
		control.setDid(did);
		control.setMessage_on(this.on);
		control.setMessage_off(this.off);
		control.start();
		
		return control;
	}
	
	private Thread identifyControl(String type){
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
		Frame frame = frameService.getOneByCondition("device_control.id;"+id+";=;int");
		this.lisFrame.add(frame);
		
		this.lightAnalysis(frame);
		this.ecAnalysis(frame);
//		this.humidityAnalysis(plant.getPlant_info().getHumidity());
//		this.temperatureAnalysis(plant.getPlant_info().getTemperature());
//		this.co2Analysis(plant.getPlant_info().getCo2());
//		this.phAnalysis(plant.getPlant_info().getpH());
	}

	@Override
	public void trackParamsAnalysis(String msg, String topic) {
		// from topic -> id   // ex : nct_collect_1
		System.out.println(msg);
		String[] split_topic = topic.split(Constant.SPLIT_PATTERN_LEVEL2);
		int t = this.findFrame(Integer.parseInt(split_topic[2]));
		if(t == -1){
			//exception here
		}
		Frame frame = lisFrame.get(t);
		
		String[] msgSplit = msg.split(Constant.SPLIT_PATTERN);
		temperatureAnalysis(msgSplit[1],frame);
		humidityAnalysis(msgSplit[2],frame);
		co2Analysis(msgSplit[3],frame);
		phAnalysis(msgSplit[4],frame);
	}
	
	private void ecAnalysis(Frame frame){
		String[] days = frame.getPlant().getPlant_info().getEc().split(Constant.SPLIT_PATTERN_LEVEL2);
		if(days.length == 1){
			String[] split = frame.getPlant().getPlant_info().getEc().split(Constant.SPLIT_PATTERN);
			if(0 == Integer.parseInt(split[2])){
				this.controlOneTime("pumpA", this.sloveTimeForEC(frame.getPlant().getPlant_info().getEc()), frame.getDevice_control().getId());
				this.controlOneTime("pumpB", this.sloveTimeForEC(frame.getPlant().getPlant_info().getEc()), frame.getDevice_control().getId());
			}
		}else {
			
			try {
				int day = timer.countDays(frame.getTime_begin());
				int s = 0;
				boolean flag = false;
				
				for(int i=0;i<days.length;i++){	
					String[] split = frame.getPlant().getPlant_info().getEc().split(Constant.SPLIT_PATTERN);
					s+= Integer.parseInt(split[2]);
					if(day > s)
						continue;
					else{
						flag = true;
						PublishServiceSeconds pa = this.controlOneTime("pumpA", this.sloveTimeForEC(days[i]),
								frame.getDevice_control().getId());
						PublishServiceSeconds pb = this.controlOneTime("pumpB", this.sloveTimeForEC(days[i]),
								frame.getDevice_control().getId());
						pa.join();
						pb.join();
					}
				}
				
				if(!flag){
					PublishServiceSeconds pa = this.controlOneTime("pumpA", 
							this.sloveTimeForEC(days[days.length - 1]), frame.getDevice_control().getId());
					PublishServiceSeconds pb = this.controlOneTime("pumpB", 
							this.sloveTimeForEC(days[days.length - 1]), frame.getDevice_control().getId());
					pa.join();
					pb.join();
				}
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void lightAnalysis(Frame frame){
		String[] days = frame.getPlant().getPlant_info().getLight_time().split(Constant.SPLIT_PATTERN_LEVEL2);
		if(days.length == 1){
			String[] split = frame.getPlant().getPlant_info().getLight_time().split(Constant.SPLIT_PATTERN);
			if(0 == Integer.parseInt(split[2])){
				this.control("led", Double.parseDouble(split[1]), frame.getDevice_control().getId(), frame.getPlant().getPlant_info().getTime_harvest()+30);
			}
		}else{
			List<Thread> lis = new ArrayList<>();
			for (int i = 0; i < days.length; i++) {
				String[] split = frame.getPlant().getPlant_info().getLight_time().split(Constant.SPLIT_PATTERN);
				if(0 != Integer.parseInt(split[2])){
					lis.add(this.control("led", Double.parseDouble(split[1]), frame.getDevice_control().getId(), Integer.parseInt(split[2])));
				}else {
					lis.add(this.control("led", Double.parseDouble(split[1]), frame.getDevice_control().getId(), 30));
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
	
	private String humidityAnalysis(String info, Frame frame){
		return null;
	}
	
	private String co2Analysis(String info, Frame frame){
		return null;
	}
	
	private String phAnalysis(String info, Frame frame){
		return null;
	}

	private String temperatureAnalysis(String info, Frame frame){
		return null;
	}
	
	private int findFrame(int id){
		for (int i = 0; i < lisFrame.size(); i++) {
			if(lisFrame.get(i).getId() == id)
				return i;
		}
		return -1;
	}
	
	private double sloveTimeForEC(String ec){
			
		String[] split = ec.split(Constant.SPLIT_PATTERN);
		double avg_ec = (Double.parseDouble(split[0]) + Double.parseDouble(split[1]))/2;
		double time = avg_ec*0.75/1.6;
		
		return time;
	}
	
}