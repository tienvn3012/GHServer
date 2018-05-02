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
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.model.response.FrameResponse;
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
	private ObjectService<Frame,FrameResponse> frameService;
	
	@Autowired
	private PasswordCryptService passService;
	
	@Autowired
	private TimerService timerService;
	
	@Autowired
	@Qualifier("devicesService")
	private ObjectService<Devices,DevicesResponse> deviceService;
	
	
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
		System.out.println("Device "+id+" request to login !");
		if(deviceService.getOneById(id) == null){
			authentication_result.publish("nct_authentication_result_"+id, ("Device not found !").getBytes(),2,true);
			System.out.println("Not found device id "+id);
		}else{
			if(passService.checkMd5Password(mes[1])){
				System.out.println("Login success !");
				Constant.lis_deviceThread.add(new DeviceThread(id));
				if(("collect").equals(mes[2])){
					
					Frame frame = frameService.getOneByCondition("device_colect.id;"+id+";=;int","harvested;false;=;boolean");
					Constant.set_frame.add(frame);
					Devices d = frame.getDevice_colect();
					d.setDevice_status(true);
					deviceService.updateE(d);
					authentication_result.publish("nct_authentication_result_"+id, ("PASS_"+frame.getPlant().getPlant_info().getTrack_time()+"\0").getBytes(),0,true);
					
//					authentication_result.publish("nct_authentication_result_"+id,
//							("PASS_"+timerService.getCurrentTime()+"_"+frame.getPlant().getPlant_info().getTrack_time()+"\0").getBytes(),0,true);
					System.out.println("PASS_"+timerService.getCurrentTime()+"_"+frame.getPlant().getPlant_info().getTrack_time()+"\0");
//					publisher.publish("nct_info_"+id, (frame.getPlant().getPlant_info().getTrack_time()+"").getBytes(), 2, true);
//					publisher.publish("nct_info_"+id, new MqttMessage("60000".getBytes()));
				}else {
					authentication_result.publish("nct_authentication_result_"+id, ("PASS\0").getBytes(),0,true);
					Frame frame = frameService.getOneByCondition("device_control.id;"+id+";=;int","harvested;false;=;boolean");
					Constant.set_frame.add(frame);

					Devices d = frame.getDevice_control();
					d.setDevice_status(true);
					deviceService.updateE(d);
					
					// open automatic thread control
					controlService.pumpWaterToFrame(frame, 0);
					controlService.plantAnalysis(frame);
				}
				
				System.out.println("Device id "+id+" loged in success !!!!");
				
			}else {
				authentication_result.publish("nct_authentication_result_"+id, ("Wrong Password!").getBytes(),2,true);
			}
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		
	}

}
