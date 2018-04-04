package vn.com.nct.controller;

import java.util.List;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.com.nct.constant.Constant;
import vn.com.nct.model.DeviceActive;
import vn.com.nct.model.DeviceStage;
import vn.com.nct.model.Devices;
import vn.com.nct.model.Frame;
import vn.com.nct.model.Layout;
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.service.objectservice.ObjectService;

@RestController
public class ControlController extends LayoutController{
	
	@Autowired
	@Qualifier("publisher")
	private MqttClient publisher;

	@Autowired
	@Qualifier("frameService")
	private ObjectService<Frame, FrameResponse> frameService;
	
	@Autowired
	@Qualifier("devicesService")
	private ObjectService<Devices, DevicesResponse> deviceService;
	
	
	
	@RequestMapping(value = "control", method = RequestMethod.GET)
	public ModelAndView getControlPage(){
		this.clear_style();
		this.set_other_layout("content", "../control.jsp");
		this.more_css.add(new Layout("control_style", "/GHServer/resources/css/control/control.css"));
		this.more_js.add(new Layout("control_js", "/GHServer/resources/js/control/control.js"));
		
		ModelAndView model = this.layout();
		
		return model;
	}
	
	@RequestMapping(value = "control/{id}/mode", method = RequestMethod.GET)
	public String modeControl(@PathVariable int id, @RequestParam(name = "mode")String mode){
		Frame frame = Constant.getItemFromSetFrame(id);		 
		
		if("on".equals(mode)){
			frame.setAutomatic_mode(true);
			Constant.updateItemOfSetFrame(frame);
			
			DeviceActive da = Constant.getDeviceActiveById(frame.getDevice_control().getId());
			
			if(da == null)
				return "{\"status\" : 0, \"error\" : \"Control device not found !\"}";
			
			for (DeviceStage device : da.getLis()) {
				this.turnStageDevice(device.getName(), device.getId(), device.isStage());
			}
			
			Constant.device_active.remove(da);
			
			Constant.startThreadByDeviceId(frame.getDevice_control().getId());
			
		}else if("off".equals(mode)){
			frame.setAutomatic_mode(false);
			this.saveStageDeviceBeforeOffAutomaticMode(frame);
			try {
				publisher.publish("nct_control_"+id, (Constant.LED_OFF).getBytes(),2,true);
				publisher.publish("nct_control_"+id, (Constant.PUMP_A_OFF).getBytes(),2,true);
				publisher.publish("nct_control_"+id, (Constant.PUMP_B_OFF).getBytes(),2,true);
			} catch (MqttPersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Constant.updateItemOfSetFrame(frame);
			Constant.stopThreadByDeviceId(frame.getDevice_control().getId());
		}else{
			return "{\"status\" : 1}";
		}
		
		
		frameService.updateE(frame);
		
		
		
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "control/{id}/led", method = RequestMethod.GET)
	public String ledControl(@PathVariable int id, @RequestParam(name="led")String led){
		try{
			if("on".equals(led)){
				publisher.publish("nct_control_"+id, (Constant.LED_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.LED_OFF).getBytes(),2,true);
			}
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "control/{id}/pumpa", method = RequestMethod.GET)
	public String pumpAControl(@PathVariable int id, @RequestParam(name="pumpa")String pumpa){
		System.out.println("pumpa");
		try{
			if("on".equals(pumpa)){
				publisher.publish("nct_control_"+id, (Constant.PUMP_A_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.PUMP_A_OFF).getBytes(),2,true);
			}
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "control/{id}/pumpb", method = RequestMethod.GET)
	public String pumpBControl(@PathVariable int id, @RequestParam(name="pumpb")String pumpb){
		System.out.println("pumpb");
		try{
			if("on".equals(pumpb)){
				publisher.publish("nct_control_"+id, (Constant.PUMP_B_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.PUMP_B_OFF).getBytes(),2,true);
			}
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "control/{id}/pumppu", method = RequestMethod.GET)
	public String pumpUpControl(@PathVariable int id, @RequestParam(name="pumppu")String pumppu){
		System.out.println("pumppu");
		try{
			if("on".equals(pumppu)){
				publisher.publish("nct_control_"+id, (Constant.PUMP_PH_UP_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.PUMP_PH_UP_OFF).getBytes(),2,true);
			}
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"status\" : 0}";
	}
	
	@RequestMapping(value = "control/{id}/pumppd", method = RequestMethod.GET)
	public String pumpDownControl(@PathVariable int id, @RequestParam(name="pumppd")String pumppd){
		System.out.println("pumppd");
		try{
			if("on".equals(pumppd)){
				publisher.publish("nct_control_"+id, (Constant.PUMP_PH_DOWN_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.PUMP_PH_DOWN_OFF).getBytes(),2,true);
			}
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"status\" : 0}";
	}
	

	
	@RequestMapping(value = "control/{id}/fan", method = RequestMethod.GET)
	public String fanControl(@PathVariable int id, @RequestParam(name="fan")String fan){
		try{
			if("on".equals(fan)){
				publisher.publish("nct_control_"+id, (Constant.FAN_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.FAN_OFF).getBytes(),2,true);
			}
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "{\"status\" : 0}";
	}
	
	private void turnStageDevice(String name, int control_id, boolean mode){
		try{
			switch (name) {
				case "led" :
					publisher.publish("nct_control_"+control_id, 
							((mode == true ? Constant.LED_ON:Constant.LED_OFF)).getBytes(),2,true);
					break;
				case "pumpa" :
					publisher.publish("nct_control_"+control_id, 
							((mode == true ? Constant.PUMP_A_ON:Constant.PUMP_A_OFF)).getBytes(),2,true);
					break;
				case "pumpb" :
					publisher.publish("nct_control_"+control_id, 
							((mode == true ? Constant.PUMP_B_ON:Constant.PUMP_B_OFF)).getBytes(),2,true);
					break;
				case "pumppu" :
					publisher.publish("nct_control_"+control_id, 
							((mode == true ? Constant.PUMP_PH_UP_ON:Constant.PUMP_PH_UP_OFF)).getBytes(),2,true);
					break;
				case "pumppd" :
					publisher.publish("nct_control_"+control_id, 
							((mode == true ? Constant.PUMP_PH_DOWN_ON:Constant.PUMP_PH_DOWN_OFF)).getBytes(),2,true);
					break;
				default :
					break;
			}
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void saveStageDeviceBeforeOffAutomaticMode(Frame frame){
		DeviceActive ds = new DeviceActive();
		ds.setId(frame.getDevice_control().getId());
		
		List<Devices> lis = deviceService.getAllBy("devices.control_device;"+ds.getId()+";=;int");
		for (Devices devices : lis) {
			ds.getLis().add(new DeviceStage(devices.getId(), devices.getDevice_name(), devices.isDevice_status()));
		}
		
		Constant.device_active.add(ds);
	}
}
