package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("minutes")
@Scope("prototype")
public class PublishServiceMinutes extends Thread{
	@Autowired
	@Qualifier("publisher3")
	private MqttClient control_device;
	
	private int    did;
	private String msg_on;
	private String msg_off;
	private double delay_time;

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			control_device.publish("nct_control_"+this.did, (this.msg_on).getBytes(), 0, true);
			sleep((long)Math.floor(delay_time));
			control_device.publish("nct_control_"+this.did, (this.msg_off).getBytes(), 0, true);
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
