package vn.com.nct.config;

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
public class MqttConfig {
	
	@Autowired
	private MqttCallback mqttCallback;
	
	private String topic = "nct_control";
	String content      = "Message from MqttPublishSample";
    int qos             = 2;
    String broker       = "tcp://iot.eclipse.org:1883";
    String clientId     = "JavaSample";
    MemoryPersistence persistence = new MemoryPersistence();
    
    @Bean
    public Message mqtt(){
         try {
        	 MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
             MqttConnectOptions connOpts = new MqttConnectOptions();
             
             connOpts.setCleanSession(true);
             System.out.println("Connecting to broker: "+broker);
             sampleClient.connect(connOpts);
             
             System.out.println("Connected");
             System.out.println("Publishing message: "+content);
             
             sampleClient.setCallback(mqttCallback);
             sampleClient.subscribe("nct_colect");
             
             MqttMessage message = new MqttMessage(content.getBytes());
             message.setQos(qos);
			sampleClient.publish(topic, message);
			System.out.println("Message published");
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
    }
}
