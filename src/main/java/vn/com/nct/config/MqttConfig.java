package vn.com.nct.config;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MqttConfig implements MqttCallback{
	
	@Autowired
	private MqttCallback logCallback;

	private MqttClient subscriber = null;
	private MqttClient publisher = null;
	private MqttClient log = null;
	
	String content      = "Message from MqttPublishSample";
    int qos             = 2;
    String broker       = "tcp://iot.eclipse.org:1883";
    MemoryPersistence persistence = new MemoryPersistence();
    
    @Bean(name = "subscribe")
    public MqttClient mqttSubscriber(){
    	 
         try {
        	 subscriber = new MqttClient(broker,"subscriber",persistence);
        	
//             MqttConnectOptions connOpts = new MqttConnectOptions();
             
//             connOpts.setCleanSession(true);
             System.out.println("Connecting to broker: "+broker);
             subscriber.connect();
            
             
             System.out.println("Connected");
             System.out.println("Publishing message: "+content);
             
             subscriber.setCallback(this);
             subscriber.subscribe("nct_colect");
             System.out.println("Subscribed topic 'nct_colect'");
             
			System.out.println("Message published");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return subscriber;
    }

    @Bean(name = "publisher")
    public MqttClient mqttPublisher(){
    	 try {
			publisher = new MqttClient(broker, "publisher");
			publisher.connect();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 return publisher;
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
    
	@Override
	public void connectionLost(Throwable arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String arg0, MqttMessage arg1){
		System.out.println(arg1);
		double t = Double.parseDouble(arg1.toString());
		if(t < 25 || t > 30){
			try{
				publisher.publish("nct_control", ("led").getBytes(), 2, true);
				System.out.println();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
