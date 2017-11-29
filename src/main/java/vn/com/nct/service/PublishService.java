package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService extends Thread{
	
	@Autowired
	private MqttClient control_device;
	
	private int delay_time;
	private String message_on;
	private String message_off;
	

	public PublishService(int delay_time, String message_on, String message_off) {
		super();
		this.delay_time = delay_time;
		this.message_on = message_on;
		this.message_off = message_off;
	}

	@Override
	public void run() {
		super.run();
		try {
			control_device.publish("nct_control", (message_on).getBytes(), 2, true);
			sleep(delay_time*60*1000);
			control_device.publish("nct_control", (message_off).getBytes(), 2, true);
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getDelay_time() {
		return delay_time;
	}

	public void setDelay_time(int delay_time) {
		this.delay_time = delay_time;
	}

	public String getMessage_on() {
		return message_on;
	}

	public void setMessage_on(String message_on) {
		this.message_on = message_on;
	}

	public String getMessage_off() {
		return message_off;
	}

	public void setMessage_off(String message_off) {
		this.message_off = message_off;
	}

	
}
