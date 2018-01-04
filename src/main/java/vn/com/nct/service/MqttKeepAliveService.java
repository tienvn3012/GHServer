package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nct.base.PasswordCryptService;
import vn.com.nct.constant.Constant;

@Service("keepAlive_callback")
public class MqttKeepAliveService implements MqttCallback{

	@Autowired
	private PasswordCryptService passService;
	
	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("keep alive from "+topic);
		
		String[] split = message.toString().split(Constant.SPLIT_PATTERN);
		if(passService.checkMd5Password(split[1])){
			Constant.lis_keepAlive.add(split[0]);
		}
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}

}
