package vn.com.nct.service;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.com.nct.base.TimerService;
import vn.com.nct.constant.Constant;
import vn.com.nct.dao.ObjectDaoSupport;
import vn.com.nct.model.Devices;
import vn.com.nct.model.Frame;
import vn.com.nct.model.Statements;
import vn.com.nct.model.SystemLogActivity;
import vn.com.nct.model.Users;
import vn.com.nct.model.response.DevicesResponse;
import vn.com.nct.model.response.FrameResponse;
import vn.com.nct.model.response.StatementResponse;
import vn.com.nct.model.response.UserResponse;
import vn.com.nct.service.objectservice.ObjectService;

@Service("log_callback")
public class MqttLogService implements MqttCallback{

	@Autowired
	private ObjectService<Devices, DevicesResponse> devicesService;
	
	@Autowired
	private ObjectService<Frame, FrameResponse> frameService;
	
	@Autowired
	private ObjectService<Users, UserResponse> userService;
	
	@Autowired
	private ObjectService<Statements, StatementResponse> statementService;
	
	@Autowired
	private ObjectDaoSupport<SystemLogActivity> logDao;
	
	@Autowired
	private TimerService timerService;
	
	@Override
	public void connectionLost(Throwable cause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		System.out.println("Receive message '"+message+"' from topic '"+topic+"'");
		String split[] = message.toString().split(";");
		
		SystemLogActivity log = new SystemLogActivity();

		Frame fr = frameService.getOneByCondition("device_control.id;"+split[1]+";=;int");
		log.setAuto(fr.isAutomatic_mode());
		log.setFrame(fr);
		log.setTime(timerService.getCurrentTime());

		Users user = userService.getOneById(1);
		log.setUsers(user);
		
		Statements s = statementService.getOneByCondition("statements.statements;"+split[2]+";=;String");
		log.setStatements(s);
		
		// write to db this log
		logDao.saveE(log);
		
		this.switchDevices(message.toString());
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}
	
	private void switchDevices(String msg){
		// log message : token;id;statement;token
		String[] split = msg.split(Constant.SPLIT_PATTERN);
		boolean status = false;
		String device = "";
		switch (split[2]) {
		case "L_1":
			device = "LED";
			status = true;
			break;
		case "F_1":
			device = "FAN";
			status = true;
			break;
		case "PA_1":
			device = "Pump A";
			status = true;
			break;
		case "PB_1":
			device = "Pump B";
			status = true;
			break;
		case "PU_1":
			device = "Pump ph up";
			status = true;
			break;
		case "PD_1":
			device = "Pump ph down";
			status = true;
			break;
		case "UP_1":
			device = "Pump up";
			status = true;
			break;
		case "PW_1":
			device = "Pump water";
			status = true;
			break;
//		case Constant.PUMP_DOWN_ON:
//			device = "Pump B";
//			status = true;
//			break;
		case "L_0":
			device = "LED";
			status = false;
			break;
		case "F_0":
			device = "FAN";
			status = false;
			break;
		case "PA_0":
			device = "Pump A";
			status = false;
			break;
		case "PB_0":
			device = "Pump B";
			status = false;
			break;
		case "PU_0":
			device = "Pump ph up";
			status = false;
			break;
		case "PD_0":
			device = "Pump ph down";
			status = false;
			break;
		case "UP_0":
			device = "Pump up";
			status = false;
			break;
		case "PW_0":
			device = "Pump water";
			status = false;
			break;
		default:
			break;
		}
		
		Devices d = devicesService.getOneByCondition("control_device;"+split[1]+";=;int",
				"device_name;"+device+";=;String");
		if(d == null){
			System.out.println("ERROR !");
		}
		d.setDevice_status(status);
		devicesService.updateE(d);
		
	}

}
