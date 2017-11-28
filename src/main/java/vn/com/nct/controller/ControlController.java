package vn.com.nct.controller;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	
	@RequestMapping(value = "control/led", method = RequestMethod.GET)
	public String ledControl(@RequestParam(name="led")String led){
		try{
			if("on".equals(led)){
				publisher.publish("nct_control", (Constant.LED_ON).getBytes(),2,true);
			}else {
				publisher.publish("nct_control", (Constant.LED_OFF).getBytes(),2,true);
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
