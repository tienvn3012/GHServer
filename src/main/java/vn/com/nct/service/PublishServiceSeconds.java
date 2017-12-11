package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service("seconds")
@Scope("prototype")
public class PublishServiceSeconds extends Thread{
	
	@Autowired
	@Qualifier("publisher")
	private MqttClient control_device;
	
	private int did;
	private double delay_time;
	private String message_on;
	private String message_off;
	
	public PublishServiceSeconds() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public PublishServiceSeconds( int did, double delay_time, String message_on,
			String message_off) {
		super();
		this.did = did;
		this.delay_time = delay_time;
		this.message_on = message_on;
		this.message_off = message_off;
	}

	@Override
	public void run() {
		super.run();
		synchronized (control_device) {
			try {
				long time_on = (long)Math.floor(delay_time*1000);
				
				control_device.publish("nct_control_"+this.did, (message_on).getBytes(), 0, true);
				sleep(time_on);
				control_device.publish("nct_control_"+this.did, (message_off).getBytes(), 0, true);

			} catch (MqttException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public double getDelay_time() {
		return delay_time;
	}

	public void setDelay_time(double delay_time) {
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
