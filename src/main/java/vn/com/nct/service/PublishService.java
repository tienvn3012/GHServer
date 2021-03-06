package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import vn.com.nct.constant.Constant;

@Service
@Scope("prototype")
public class PublishService extends Thread{
	
	@Autowired
	@Qualifier("publisher")
	private MqttClient control_device;
	
	private int did;
	private double delay_time;
	private String message_on;
	private String message_off;
	private int stop_time;
	

	
	
	public PublishService() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public PublishService(int did,double delay_time, String message_on, String message_off, int stop_time) {
		super();
		this.did = did;
		this.delay_time = delay_time;
		this.message_on = message_on;
		this.message_off = message_off;
		this.stop_time = stop_time;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		super.run();
		if(Constant.getItemFromSetFrameByControlId(did).isAutomatic_mode()){
			int index = -1;
			int thread_index = -1;
			for (int i = 0; i < Constant.lis_deviceThread.size(); i++) {
				if(Constant.lis_deviceThread.get(i).getId() == this.did){
					Constant.lis_deviceThread.get(i).getLis().add(this);
					thread_index = Constant.lis_deviceThread.get(i).getLis().size() - 1;
					System.out.println(Constant.lis_deviceThread.get(i).getLis().size() + "-" +thread_index);
					index = i;
					break;
				}
			}
			
			if(index == -1)
				this.stop();
			
			synchronized (control_device) {
				try {
					System.out.println(message_on);
					int day = 1;
					long time_on = (long)Math.floor(delay_time*1000);
					long time_off = 24*1000 - time_on;
					while(day <= stop_time){
						sleep(10*1000);
						control_device.publish("nct_control_"+this.did, (message_on).getBytes(), 0, true);
						sleep(time_on);
						control_device.publish("nct_control_"+this.did, (message_off).getBytes(), 0, true);
						sleep(time_off);
						
					}
					
					System.out.println(Constant.lis_deviceThread.get(index).getLis().size() + "-" +thread_index);
					Constant.lis_deviceThread.get(index).getLis().remove(thread_index);
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


	public int getStop_time() {
		return stop_time;
	}


	public void setStop_time(int stop_time) {
		this.stop_time = stop_time;
	}



	
}
