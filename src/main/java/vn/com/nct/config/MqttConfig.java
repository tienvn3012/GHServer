package vn.com.nct.config;


import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.com.nct.model.Devices;
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.service.controlservice.AutomaticControlService;
import vn.com.nct.service.objectservice.ObjectService;


@Configuration
public class MqttConfig implements MqttCallback{
	
	@Autowired
	@Qualifier(value = "log_callback")
	private MqttCallback logCallback;
	
	@Autowired
	@Qualifier(value = "authentication_callback")
	private MqttCallback authenticationCallback;
	
	@Autowired
	@Qualifier(value = "keepAlive_callback")
	private MqttCallback keepAliveCcallback;
	
	@Autowired
	@Qualifier(value = "automaticControl")
	private AutomaticControlService automatic;
	
	@Autowired
	@Qualifier("devicesService")
	private ObjectService<Devices, DevicesResponse> deviceService;

	private MqttClient subscriber 			 = null;
	private MqttClient publisher 			 = null; // for led
	private MqttClient publisher2 			 = null; // for pump
	private MqttClient log 					 = null;
	private MqttClient authentication 		 = null;
	private MqttClient authentication_result = null;
	private MqttClient keep_alive 			 = null;
	private MqttClient publisher3			 = null; // for one time
	
	
	String content      = "Message from MqttPublishSample";
    int qos             = 2;
    String broker       = "tcp://iot.eclipse.org:1883";
    MemoryPersistence persistence = new MemoryPersistence();
    
    @Bean(name = "subscribe")
    public MqttClient mqttSubscriber(){
    	 
         try {
        	 subscriber = new MqttClient(broker,"subscriber",persistence);
             System.out.println("Connecting to broker: "+broker);
             subscriber.connect();
            
             
             System.out.println("Connected");
 
             subscriber.subscribe("nct_collect");
             System.out.println("subscribe topic : nct_colect !!!!!");
             subscriber.setCallback(this);

		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return subscriber;
    }

    @Bean(name = "publisher")
    public MqttClient mqttPublisher(){ // service for light, control by hours
    	 try {
			publisher = new MqttClient(broker, "publisher");
			publisher.connect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return publisher;
    }
    
    @Bean(name = "publisher2")
    public MqttClient mqttPublisher2(){ // service for pump, control by seconds
    	 try {
			publisher2 = new MqttClient(broker, "publisher2");
			publisher2.connect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return publisher2;
    }
    
    @Bean(name = "publisher3")
    public MqttClient mqttPublisher3(){ // service for control onetime
    	 try {
			publisher3 = new MqttClient(broker, "publisher3");
			publisher3.connect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return publisher3;
    }
    
    @Bean(name = "log")
    public MqttClient mqttLog(){
    	try {
			log = new MqttClient(broker, "log");
			log.connect();
			log.setCallback(logCallback);
			log.subscribe("nct_log");
			System.out.println("Subscribed topic 'Log'");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return log;
    }
    
    @Bean(name = "keep_alive")
    public MqttClient mqttKeepAlive(){
    	try {
			log = new MqttClient(broker, "keep_alive");
			log.connect();
			log.setCallback(keepAliveCcallback);
			log.subscribe("nct_keep_alive");
			System.out.println("Subscribed topic 'Keep alive'");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return keep_alive;
    }
    
    @Bean(name = "authentication")
    public MqttClient mqttAuthentication(){
    	try{
    		authentication = new MqttClient(broker, "authentication");
    		authentication.connect();
    		authentication.setCallback(authenticationCallback );
    		authentication.subscribe("nct_authentication");
    		System.out.println("subscribed topic nct_authentication");
    	}catch(MqttException e){
    		e.printStackTrace();
    	}
    	return authentication;
    }
    
    @Bean(name = "authentication_result")
    public MqttClient mqttAuthenticationResult(){
    	try{
    		authentication_result = new MqttClient(broker, "authentication_result");
    		authentication_result.connect();
    	}catch(MqttException e){
    		e.printStackTrace();
    	}
    	return authentication_result;
    }
    
   
    
	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void messageArrived(String topic, MqttMessage message){
//		String msg = message.toString() + ";"+timer.getCurrentTime()+";nct";
		System.out.println("Receive message '"+message+"' from topic '"+topic+"'");
		
		String[] split = message.toString().split(";");
		int id = Integer.parseInt(split[0]);
		
		Devices d = deviceService.getOneById(id);
		if(d == null) {
			System.out.println("Reject message cause device not found !!!!");
			return;
		}
		if(!d.isDevice_status()) {
			System.out.println("Reject message cause device've not loged in !!!!");
			return;
		}
		
		try {
			publisher.publish("nct_collect_"+split[0], message.getPayload(), 0, false);
			System.out.println("publish message \""+message.toString()+"\" to topic nct_collect_"+split[0]);
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		automatic.trackParamsAnalysis(message.toString(), topic);
		
	}
}
