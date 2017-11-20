package vn.com.nct.config;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vn.com.nct.model.Message;

@Configuration
public class MqttConfig implements MqttCallback{
	
	@Autowired
	private MqttCallback mqttCallback;
	
	private MqttClient sampleClient = null;
	private MqttClient client = null;
	
	private String topic = "nct_control";
	String content      = "Message from MqttPublishSample";
    int qos             = 2;
    String broker       = "tcp://iot.eclipse.org:1883";
    String clientId     = "das";
//    MemoryPersistence persistence = new MemoryPersistence();
    
    @Bean
    public MqttClient mqtt(){
    	 
         try {
        	 sampleClient = new MqttClient(broker, clientId);
        	 client = new MqttClient(broker, "id");
//             MqttConnectOptions connOpts = new MqttConnectOptions();
             
//             connOpts.setCleanSession(true);
             System.out.println("Connecting to broker: "+broker);
             sampleClient.connect();
             client.connect();
             
             System.out.println("Connected");
             System.out.println("Publishing message: "+content);
             
             sampleClient.setCallback(this);
             sampleClient.subscribe("nct_colect");
             
             
			System.out.println("Message published");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return sampleClient;
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
		System.out.println(arg0);
		System.out.println(arg1);
		String xxx = "hello";
		MqttMessage message = new MqttMessage(xxx.getBytes());
		System.out.println("herewwq2req");
        message.setQos(0);
        System.out.println("hereqwr23");

			System.out.println("here21367");
//			client.publish("nct_control", message);
			try{
			client.publish("nct_control", ("message").getBytes(), 0, true);
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("here");
		
	}
}
