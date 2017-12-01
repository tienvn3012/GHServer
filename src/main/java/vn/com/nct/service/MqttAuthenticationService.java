package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.com.nct.base.PasswordCryptService;
//import vn.com.nct.base.TimerService;
import vn.com.nct.constant.Constant;
import vn.com.nct.model.Devices;
import vn.com.nct.model.Frame;

@Service("authentication_callback")
public class MqttAuthenticationService implements MqttCallback{

	@Autowired
	@Qualifier("authentication_result")
	private MqttClient authentication_result;
	
	@Autowired
	@Qualifier("subscribe")
	private MqttClient subscribe;
	
	@Autowired
	private PasswordCryptService passService;
	
//	@Autowired
//	private TimerService timerService;
	
	@Autowired
	private ObjectService<Devices> deviceService;
	
	@Autowired
	private ObjectService<Frame> frameService;
	
	@Autowired
	private AutomaticControlService controlService;
	
	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		if(!("nct_authentication").equals(topic))
			return;
		
		String[] mes = message.toString().split(Constant.SPLIT_PATTERN);
		int id = Integer.parseInt(mes[0]);
		if(deviceService.getOneById(id) == null){
			authentication_result.publish("nct_authentication_result_"+id, ("Device not found !").getBytes(),2,true);
		}else{
			if(passService.checkMd5Password(mes[1])){
				System.out.println("Passed");
				authentication_result.publish("nct_authentication_result_"+id, ("OK\0").getBytes(),0,true);
				if(("collect").equals(mes[2])){
					subscribe.subscribe("nct_collect_"+id);
					System.out.println("nct_collect_"+id);
				}else {
					System.out.println("here");
					// find frame by condition and get plant info then open automatic thread control
					Frame frame = frameService.getOneByCondition("device_control.id;"+id+";=;int");
					System.out.println(frame);
					System.out.println(frame.getPlant().getPlant_info().getLight_time());
					String[] split = frame.getPlant().getPlant_info().getLight_time().split(Constant.SPLIT_PATTERN);
					
					controlService.control("led", Double.parseDouble(split[1]), id);
				}
					
			}else {
				authentication_result.publish("nct_authentication_result_"+id, ("Wrong Password!").getBytes(),2,true);
			}
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}

}
