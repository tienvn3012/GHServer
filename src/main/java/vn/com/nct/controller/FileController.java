package vn.com.nct.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
	
	@Autowired
	@Qualifier("publisher")
	private MqttClient publisher;
	
	@RequestMapping(value="/image",method = RequestMethod.GET)
	@ResponseBody 
	public void loadVideoFile(@RequestParam String image , HttpServletResponse response) {
		String img[] = image.split(Pattern.quote(".")); 
		String subfix = img[img.length - 1];
	    try {           
	        String filePath = "D:/TienVN/GH/img/"+image;        
	        int fileSize = (int) new File(filePath).length();
	        response.setContentLength(fileSize);
	        response.setContentType("image/"+subfix);
	        FileInputStream inputStream = new FileInputStream(filePath);
	        ServletOutputStream outputStream = response.getOutputStream();
	        int value = IOUtils.copy(inputStream, outputStream);
	        System.out.println("File Size :: "+fileSize);
	        System.out.println("Copied Bytes :: "+value);
	        IOUtils.closeQuietly(inputStream);
	        IOUtils.closeQuietly(outputStream);
	        response.setStatus(HttpServletResponse.SC_OK);
	    } catch (java.io.FileNotFoundException e) {         
	        response.setStatus(HttpStatus.NOT_FOUND.value());
	    } catch (Exception e) {         
	        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    }
	}
	
	@RequestMapping(value = "/file", method = RequestMethod.GET)
	@ResponseBody
	public String buildCodeOTA(@RequestParam String file,@RequestParam(required=false) int id){
		
		String filePath = "D:/TienVN/GH/code/"+file;
		File f = new File(filePath);
		System.out.println(f.exists());
		System.out.println(filePath);
		FileReader fr;
		try {
			fr = new FileReader(filePath);
//			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String temp = "";
			
			String line;
			while((line = br.readLine()) != null){
				System.out.println(line);
				temp += line;
			}
			br.close();
			fr.close();
			System.out.println(temp);
//			publisher.publish("nct_restart_"+id, new MqttMessage(temp.getBytes()));
			publisher.publish("nct_demo", new MqttMessage(temp.getBytes()));
			publisher.publish("nct_demo", new MqttMessage("dmthai".getBytes()));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttPersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MqttException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "{\"status\" : 1}";
	}
}
