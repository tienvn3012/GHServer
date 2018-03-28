package vn.com.nct.service.controlservice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.com.nct.base.TimerService;
import vn.com.nct.constant.Constant;
import vn.com.nct.model.Devices;
import vn.com.nct.model.Frame;
import vn.com.nct.model.FrameDataColection;
import vn.com.nct.model.response.FrameDataCollectionResponse;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.service.PublishService;
import vn.com.nct.service.PublishServiceAnsyn;
import vn.com.nct.service.PublishServiceMinutes;
import vn.com.nct.service.PublishServiceOneTime;
import vn.com.nct.service.PublishServiceSeconds;
import vn.com.nct.service.analysisservice.PlantAnalysisService;
import vn.com.nct.service.objectservice.ObjectService;

@Service("automaticControl")
public class AutomaticControlServiceIplm implements AutomaticControlService{
	
	private String on;
	private String off;
	

	@Autowired
	private TimerService timer;
	
	@Autowired
	private PlantAnalysisService analysisService;
	
	@Autowired
	@Qualifier(value = "frameService")
	private ObjectService<Frame,FrameResponse> frameService;
	
	@Autowired
	@Qualifier("frameDataCollectionService")
	private ObjectService<FrameDataColection, FrameDataCollectionResponse> frameDataCollectionService;
	
	@Autowired
	@Qualifier("devicesService")
	private ObjectService<Devices, Object> devicesService;
	
	@Autowired
	private PublishServiceOneTime oneTime;
	
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
	private PublishServiceSeconds pumpPHDownControlService;
	
	@Autowired
	private PublishServiceAnsyn pumpUpControlService;
	
	@Autowired
	private PublishServiceMinutes pumpWaterControlService;

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
	public PublishServiceSeconds controlSeconds(String type, double time, int did, boolean ansyn) {
		
		PublishServiceSeconds control = (PublishServiceSeconds)this.identifyControl(type);
		control.setDelay_time(time);
		control.setDid(did);
		control.setMessage_on(this.on);
		control.setMessage_off(this.off);
		control.setAnsyn(ansyn);
		control.start();
		
		return control;
	}
	
	@Override
	public PublishServiceAnsyn controlAnsyn(String type, double time, int did) {
		PublishServiceAnsyn control = (PublishServiceAnsyn)this.identifyControl(type);
		control.setDelay_time(time);
		control.setDid(did);
		control.setMessage_on(this.on);
		control.setMessage_off(this.off);
		control.start();
		
		return control;
	}
	
	@Override
	public PublishServiceMinutes controlMinutes(String type, double time, int did) {
		PublishServiceMinutes control = (PublishServiceMinutes)this.identifyControl(type);
		control.setDelay_time(time);
		control.setDid(did);
		control.setMsg_on(this.on);
		control.setMsg_off(this.off);
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
			case "pumpPhUp" :
				this.on = Constant.PUMP_PH_UP_ON;
				this.off = Constant.PUMP_PH_UP_OFF;
				return this.pumpPHUpControlService;
			case "pumpPhDown" :
				this.on = Constant.PUMP_PH_DOWN_ON;
				this.off = Constant.PUMP_PH_UP_OFF;
				return this.pumpPHDownControlService;
			case "pumpUp" :
				this.on = Constant.PUMP_UP_ON;
				this.off = Constant.PUMP_UP_OFF;
				return this.pumpUpControlService;
			case "pumpWater" :
				this.on = Constant.PUMP_WATER_ON;
				this.off = Constant.PUMP_WATER_OFF;
				return this.pumpWaterControlService;
			default :
				return null;
		}
	}
	
	@Override
	public void pumpWaterToFrame(Frame frame,int water) {
		System.out.println("pump begin - "+water);
		if(water < 10){
			this.controlMinutes("pumpWater",5, frame.getDevice_control().getId());
		}
		Devices pumpup =  devicesService.getOneByCondition(
				"control_device;"+frame.getDevice_control().getId()+";=;int",
				"device_name;Pump up;=;String");
		System.out.println(pumpup.getId());
		if(!pumpup.isDevice_status()){
			this.controlAnsyn("pumpUp",300, frame.getDevice_control().getId());
		}
		System.out.println("pump end");
	}

	@Override
	public void plantAnalysis(Frame frame) {
		
		if(frame.isAutomatic_mode()){
			this.lightAnalysis(frame);
			this.ecAnalysis(frame);
		}
		
	}

	@Override
	public void trackParamsAnalysis(String msg, String topic) {
		
		String[] msgSplit = msg.split(Constant.SPLIT_PATTERN);
		
		int t = this.findFrame(Integer.parseInt(msgSplit[0]));
		if(t == -1){
			//exception here
			System.out.println("Frame not found !!!!");
			return;
		}
		Frame frame = (new ArrayList<>(Constant.set_frame)).get(t);
		FrameDataColection fdc = new FrameDataColection(msg);
		
		fdc.setTime(timer.getCurrentTime());
		fdc.setFrame(frame);
		frameDataCollectionService.saveE(fdc);

		System.out.println("Data saved !!!!");
		
		this.pumpWaterToFrame(frame, Integer.parseInt(msgSplit[5]));
		if(frame.isAutomatic_mode()){
			temperatureAnalysis(msgSplit[1],frame);
			humidityAnalysis(msgSplit[2],frame);
			co2Analysis(msgSplit[3],frame);
			phAnalysis(msgSplit[4],frame);
		}
	}
	
	private void ecAnalysis(Frame frame){
		String[] days = frame.getPlant().getPlant_info().getEc().split(Constant.SPLIT_PATTERN_LEVEL2);
		if(days.length == 1){
			String[] split = frame.getPlant().getPlant_info().getEc().split(Constant.SPLIT_PATTERN);
			if(0 == Integer.parseInt(split[2])){
				this.controlSeconds("pumpA", this.sloveTimeForEC(frame.getPlant().getPlant_info().getEc()), 
						frame.getDevice_control().getId(),false);
				this.controlSeconds("pumpB", this.sloveTimeForEC(frame.getPlant().getPlant_info().getEc()),
						frame.getDevice_control().getId(),false);
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
						PublishServiceSeconds pa = this.controlSeconds("pumpA", this.sloveTimeForEC(days[i]),
								frame.getDevice_control().getId(),false);
						PublishServiceSeconds pb = this.controlSeconds("pumpB", this.sloveTimeForEC(days[i]),
								frame.getDevice_control().getId(),false);
						pa.join();
						pb.join();
					}
				}
				
				if(!flag){
					PublishServiceSeconds pa = this.controlSeconds("pumpA", this.sloveTimeForEC(days[days.length - 1]),
							frame.getDevice_control().getId(), false);
					PublishServiceSeconds pb = this.controlSeconds("pumpB", this.sloveTimeForEC(days[days.length - 1]),
							frame.getDevice_control().getId(), false);
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
		System.out.println("light");
		String[] days = frame.getPlant().getPlant_info().getLight_time().split(Constant.SPLIT_PATTERN_LEVEL2);
		if(days.length == 1){
			String[] split = frame.getPlant().getPlant_info().getLight_time().split(Constant.SPLIT_PATTERN);
			if(0 == Integer.parseInt(split[2])){
				this.control("led", Double.parseDouble(split[1]), frame.getDevice_control().getId(),
						frame.getPlant().getPlant_info().getTime_harvest()+30);
			}
		}else{
			List<Thread> lis = new ArrayList<>();
			for (int i = 0; i < days.length; i++) {
				String[] split = frame.getPlant().getPlant_info().getLight_time().split(Constant.SPLIT_PATTERN);
				if(0 != Integer.parseInt(split[2])){
					lis.add(this.control("led", Double.parseDouble(split[1]),
							frame.getDevice_control().getId(), Integer.parseInt(split[2])));
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
		double humid = Double.parseDouble(info);
		String[] split = frame.getPlant().getPlant_info().getHumidity().split(Constant.SPLIT_PATTERN_LEVEL2);
		if(split.length == 1){
			this.controlFanByHumidity(split[0], frame, humid);
		}else{
			try {
				int day = timer.countDays(frame.getTime_begin());
				
				if(day > frame.getPlant().getPlant_info().getTime_harvest()){
					this.controlFanByHumidity(split[split.length - 1], frame, humid);
				}else{
					int now = 0;
					int stage = 0;
					for (int i = 0; i < split.length - 1; i++) {
						now += Integer.parseInt(split[i].split(Constant.SPLIT_PATTERN)[2]);
						if(now >= day){
							stage = i;
							break;
						}
					}
					
					this.controlFanByHumidity(split[stage], frame, humid);
				}
				
			} catch (ParseException e) {
				System.out.println("Error while count day !!!!");
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	private String co2Analysis(String info, Frame frame){
		return null;
	}
	
	private String phAnalysis(String info, Frame frame){
		double ph = Double.parseDouble(info);
		
		String[] split = frame.getPlant().getPlant_info().getpH().split(Constant.SPLIT_PATTERN_LEVEL2);
		if(split.length == 1){
			int action = analysisService.phAnalysisService(split[0], ph);
			this.controlPumpPhByAction(action, frame);
		}else{
			try {
				int day = timer.countDays(frame.getTime_begin());
				
				if(day > frame.getPlant().getPlant_info().getTime_harvest()){
					int action = analysisService.phAnalysisService(split[split.length - 1], ph);
					this.controlPumpPhByAction(action, frame);
				}else{
					int now = 0;
					int stage = 0;
					for (int i = 0; i < split.length - 1; i++) {
						now += Integer.parseInt(split[i].split(Constant.SPLIT_PATTERN)[2]);
						if(now >= day){
							stage = i;
							break;
						}
					}
					int action = analysisService.phAnalysisService(split[stage], ph);
					this.controlPumpPhByAction(action, frame);
				}
				
			} catch (ParseException e) {
				System.out.println("Error while count day !!!!");
				e.printStackTrace();
			}
		}
		
		
		return null;
	}

	private String temperatureAnalysis(String info, Frame frame){
		return null;
	}
	
	private int findFrame(int id){
		List<Frame> lis = new ArrayList<>(Constant.set_frame);
		for (int i = 0; i < lis.size(); i++) {
			if(lis.get(i).getDevice_colect().getId() == id){
				return i;
			}
		}
		return -1;
	}
	
	private double sloveTimeForEC(String ec){
			
		String[] split = ec.split(Constant.SPLIT_PATTERN);
		double avg_ec = (Double.parseDouble(split[0]) + Double.parseDouble(split[1]))/2;
		double time = avg_ec*0.75/1.6;
		
		return time;
	}

	private void controlFanByHumidity(String split, Frame frame, double humid){
		String[] s = split.split(Constant.SPLIT_PATTERN);
		double min = Double.parseDouble(s[0]);
		double max = Double.parseDouble(s[1]);
		
		if(humid < min){
			// do st we still don't know =)))
		}
		
		if(humid > max){
			Devices d = devicesService.getOneByCondition(
					"devices.control_device;"+frame.getDevice_control().getId()+";=;int",
					"device_type.id;3;=;int");
			if(!d.isDevice_status()){
				oneTime.setDid(frame.getDevice_control().getId());
				oneTime.setMsg(Constant.FAN_ON);
				oneTime.start();
			}
		}
		
		if(min <= humid && humid <= max){
			Devices d = devicesService.getOneByCondition(
					"devices.control_device;"+frame.getDevice_control().getId()+";=;int",
					"device_type.id;3;=;int");
			if(!d.isDevice_status()){
				// nothing will happend ^^
			}else{
				oneTime.setDid(frame.getDevice_control().getId());
				oneTime.setMsg(Constant.FAN_OFF);
				oneTime.start();
			}
		}
	}

	private void controlPumpPhByAction(int action, Frame frame){
		switch	(action){
			case 0: // don't pump
				break;
			case 1: // pump ph up litle
				this.controlSeconds("pumpPhUp", 10, 
						frame.getDevice_control().getId(), true);
				break;
			case 2: // pump ph up much
				this.controlSeconds("pumpPhUp", 20, 
						frame.getDevice_control().getId(), true);
				break;
			case 3: // pump ph down litle
				this.controlSeconds("pumpPhDown", 10, 
						frame.getDevice_control().getId(), true);
				break;
			case 4: // pump ph down much
				this.controlSeconds("pumpPhDown", 20, 
						frame.getDevice_control().getId(), true);
				break;
			default :
				break;
		}
	}

	

	
}
