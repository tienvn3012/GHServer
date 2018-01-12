package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nct.constant.Constant;
import vn.com.nct.model.Devices;
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.service.objectservice.ObjectService;

@Service("log_callback")
public class MqttLogService implements MqttCallback{

	@Autowired
	private ObjectService<Devices, DevicesResponse> devicesService;
	
	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Receive message '"+message+"' from topic '"+topic+"'");
		// write to db this log
		
		this.switchDevices(message.toString());
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	
	private void switchDevices(String msg){
		// log message : token;id;statement;token
		String[] split = msg.split(Constant.SPLIT_PATTERN);
		boolean status = false;
		String device = "";
		System.out.println("sssss" + split[2]);
		switch (split[2]) {
		case "L_1":
			device = "LED";
			status = true;
			break;
		case "F_1":
			device = "FAN";
			status = true;
			break;
		case "PA_1":
			device = "Pump A";
			status = true;
			break;
		case "PB_1":
			device = "Pump B";
			status = true;
			break;
//		case Constant.PUMP_UP_ON:
//			device = "Pump B";
//			status = true;
//			break;
//		case Constant.PUMP_DOWN_ON:
//			device = "Pump B";
//			status = true;
//			break;
		case "L_0":
			device = "LED";
			status = false;
			break;
		case "F_0":
			device = "FAN";
			status = false;
			break;
		case "PA_0":
			device = "Pump A";
			status = false;
			break;
		case "PB_0":
			device = "Pump B";
			status = false;
			break;
		default:
			break;
		}
		
		Devices d = devicesService.getOneByCondition("control_device;"+split[1]+";=;int",
				"device_name;"+device+";=;String");
		if(d == null){
			System.out.println("ERROR !");
		}
		d.setDevice_status(status);
		devicesService.updateE(d);
		
	}

}
