package vn.com.nct.service;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import vn.com.nct.base.PasswordCryptService;
import vn.com.nct.base.TimerService;
import vn.com.nct.constant.Constant;
import vn.com.nct.model.DeviceThread;
import vn.com.nct.model.Devices;
import vn.com.nct.model.Frame;
import vn.com.nct.service.controlservice.AutomaticControlService;
import vn.com.nct.service.objectservice.ObjectService;

@Service("authentication_callback")
public class MqttAuthenticationService implements MqttCallback{

	@Autowired
	@Qualifier("authentication_result")
	private MqttClient authentication_result;
	
	@Autowired
	@Qualifier("subscribe")
	private MqttClient subscribe;
	
	@Autowired
	@Qualifier("publisher")
	private MqttClient publisher;
	
	@Autowired
	@Qualifier(value = "frameService")
	private ObjectService<Frame,Object> frameService;
	
	@Autowired
	private PasswordCryptService passService;
	
	@Autowired
	private TimerService timerService;
	
	@Autowired
	private ObjectService<Devices,Object> deviceService;
	
	
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
				
				Constant.lis_deviceThread.add(new DeviceThread(id));
				if(("collect").equals(mes[2])){
					authentication_result.publish("nct_authentication_result_"+id, ("OK_"+timerService.getCurrentTime()+"\0").getBytes(),0,true);
//					Frame frame = frameService.getOneByCondition("device_control.id;"+id+";=;int");
//					publisher.publish("nct_info_"+id, (frame.getPlant().getPlant_info().getTrack_time()+"").getBytes(), 2, true);
//					publisher.publish("nct_info_"+id, new MqttMessage("60000".getBytes()));
					
					subscribe.subscribe("nct_collect_"+id);
					System.out.println("nct_collect_"+id);
				}else {
					authentication_result.publish("nct_authentication_result_"+id, ("PASS\0").getBytes(),0,true);
					System.out.println("Device id "+id+" loged in !!!!");
					// open automatic thread control
					controlService.plantAnalysis(id);
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
