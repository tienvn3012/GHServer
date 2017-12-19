package vn.com.nct.controller;

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
import vn.com.nct.model.Layout;

@RestController
public class ControlController extends LayoutController{
	
	@Autowired
	@Qualifier("publisher")
	private MqttClient publisher;
	
	@RequestMapping(value = "control", method = RequestMethod.GET)
	public ModelAndView getControlPage(){
		this.clear_style();
		this.set_other_layout("content", "../control.jsp");
		this.more_css.add(new Layout("control_style", "/GHServer/resources/css/control/control.css"));
		this.more_js.add(new Layout("control_js", "/GHServer/resources/js/control/control.js"));
		
		ModelAndView model = this.layout();
		
		return model;
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
	
	@RequestMapping(value = "control/{id}/pumpup", method = RequestMethod.GET)
	public String pumpUpControl(@PathVariable int id, @RequestParam(name="pumpup")String pumpup){
		try{
			if("on".equals(pumpup)){
				publisher.publish("nct_control_"+id, (Constant.PUMP_UP_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.PUMP_UP_OFF).getBytes(),2,true);
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
	
	@RequestMapping(value = "control/{id}/pumpdown", method = RequestMethod.GET)
	public String pumpDownControl(@PathVariable int id, @RequestParam(name="pumpdown")String pumpdown){
		try{
			if("on".equals(pumpdown)){
				publisher.publish("nct_control_"+id, (Constant.PUMP_DOWN_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control_"+id, (Constant.PUMP_DOWN_OFF).getBytes(),2,true);
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
}
