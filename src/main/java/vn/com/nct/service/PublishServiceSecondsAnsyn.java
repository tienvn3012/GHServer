package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PublishServiceSecondsAnsyn extends Thread{

	@Autowired
	@Qualifier("publisher3")
	private MqttClient control_device;
	
	private boolean active;
	private int did;
	private String msg_on;
	private String msg_off;
	private double delay_time;
	
	
	@Override
	public void run() {
		super.run();
		
		while(true){
			if(active){
				try {
					long time_on = (long)Math.floor(delay_time*1000);
					sleep(1000);
					control_device.publish("nct_control_"+this.did, new MqttMessage(msg_on.getBytes()));
					sleep(time_on);
					control_device.publish("nct_control_"+this.did, new MqttMessage(msg_off.getBytes()));
					sleep(1000);
					this.active = false;
				} catch (MqttException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getMsg_on() {
		return msg_on;
	}
	public void setMsg_on(String msg_on) {
		this.msg_on = msg_on;
	}
	public String getMsg_off() {
		return msg_off;
	}
	public void setMsg_off(String msg_off) {
		this.msg_off = msg_off;
	}
	public double getDelay_time() {
		return delay_time;
	}
	public void setDelay_time(double delay_time) {
		this.delay_time = delay_time;
	}
	
	
	
}
