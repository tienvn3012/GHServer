package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;


@Service
public class MqttService implements MqttCallback{
	

	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String arg0, MqttMessage arg1)  {
		System.out.println("Received message '"+arg1+"' from topic '"+arg0+"'");
//		System.out.println("heresacs");
//		MqttMessage message = new MqttMessage("hello".getBytes());
//		System.out.println("herewwq2req");
//        message.setQos(2);
//        System.out.println("hereqwr23");
//		try {
//			System.out.println("here21367");
//			mqttClient.publish("nct_control", message);
//			System.out.println("here");
//		} catch (MqttPersistenceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MqttException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
