package vn.com.nct.constant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import vn.com.nct.model.DeviceActive;
import vn.com.nct.model.DeviceThread;
import vn.com.nct.model.Frame;
import vn.com.nct.model.response.ModelProperties;

public class Constant {

	
	
	// keep_alive_message : id;password;nct
	public static List<String> lis_keepAlive = new ArrayList<>();
	
	public static Set<Frame> set_frame = new HashSet<>();
	public static Set<DeviceActive> device_active = new HashSet<>();
	public static List<DeviceThread> lis_deviceThread = new ArrayList<>();
	/*
	 * condition standard : name_of_argument;value;compare;datatype
	 * plant param standad : min;max;time_min2;max2;time2
	 * if plant param not change in all life time : min;max;0
	 * time unit : default is 'day'
	 * 
	 * authentication message : id;password;type
	 * track message : id;temp;humid;co2;ph;water;time;token
	 * log message : token;id;statement;token
	 * 
	 */
	public static final String SPLIT_PATTERN = ";";
	public static final String SPLIT_PATTERN_LEVEL2 = "_";
	
	// Control syntax
	public static final String LED_ON 			= "L_1\0";
	public static final String FAN_ON 			= "F_1\0";
	public static final String HEAT_LED_ON 		= "HL_1\0";
	public static final String PUMP_A_ON 		= "PA_1\0";
	public static final String PUMP_B_ON 		= "PB_1\0";
	public static final String PUMP_PH_UP_ON 	= "PU_1\0";
	public static final String PUMP_PH_DOWN_ON 	= "PD_1\0";
	public static final String PUMP_UP_ON		= "UP_1\0";
	public static final String PUMP_WATER_ON	= "PW_1\0";
	
	public static final String LED_OFF  		= "L_0\0";
	public static final String FAN_OFF 			= "F_0\0";
	public static final String HEAT_LED_OFF 	= "HL_0\0";
	public static final String PUMP_A_OFF 		= "PA_0\0";
	public static final String PUMP_B_OFF 		= "PB_0\0";
	public static final String PUMP_PH_UP_OFF 	= "PU_0\0";
	public static final String PUMP_PH_DOWN_OFF = "PD_0\0";
	public static final String PUMP_UP_OFF		= "UP_0\0";
	public static final String PUMP_WATER_OFF	= "PW_0\0";
	
	
	
	//model
	public static final List<ModelProperties> user_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("id", "int", "ignore", "ignore",null));
		add(new ModelProperties("username","String","inputtext","required",null));
		add(new ModelProperties("avatar", "img","img","notrequired",null));
		add(new ModelProperties("info", "Object", "object", "ignore",null));
		add(new ModelProperties("role", "Object", "object", "ignore",null));
		add(new ModelProperties("create_by", "int", "ignore", "ignore",null));
		add(new ModelProperties("create_time", "String", "ignore", "ignore",null));
		add(new ModelProperties("last_login", "String", "ignore", "ignore",null));
		add(new ModelProperties("active", "boolean", "ignore", "ignore",null));
		add(new ModelProperties("create_to", "boolean", "ignore", "ignore",null));
	}};
	
	public static final List<ModelProperties> info_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("id", "int", "ignore", "ignore",null));
		add(new ModelProperties("level", "int", "select_values_1;2;3", "required",null));
		add(new ModelProperties("fullname", "String", "inputtext", "required",null));
		add(new ModelProperties("email", "String", "inputtext", "required",null));
		add(new ModelProperties("phone", "String", "inputtext", "required;minlength_9;maxlength_12",null));
		add(new ModelProperties("address", "String", "inputtext", "required",null));
		add(new ModelProperties("date_of_birth", "String", "inputtext", "required", "ex : 01/10/1995",null));
		add(new ModelProperties("gender", "boolean", "select_values_male;female", "required",null));
	}};
	
	public static final List<ModelProperties> frame_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
		{
			add(new ModelProperties("id", "int", "ignore", "ignore",null));
			add(new ModelProperties("plant", "Object", "object", "ignore",null));
			add(new ModelProperties("time_begin", "String", "ignore", "ignore",null));
			add(new ModelProperties("device_control", "Object", "object", "ignore",null));
			add(new ModelProperties("device_collect", "Object", "object", "ignore",null));
			add(new ModelProperties("available_frame", "Object", "object", "ignore",null));
			add(new ModelProperties("automatic_mode", "boolean", "radio_values_on;off", "required",null));
			add(new ModelProperties("harvested", "boolean", "ignore", "ignore",null));
		}
	};
	
	public static final List<ModelProperties> available_frame_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
		{
			add(new ModelProperties("id", "int", "ignore", "ignore",null));
			add(new ModelProperties("status", "boolean", "ignore", "ignore",null));
			add(new ModelProperties("image", "img", "img", "notrequired",null));
		}
	};
	
	public static final List<ModelProperties> plant_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
		{
			add(new ModelProperties("id", "int", "ignore", "ignore",null));
			add(new ModelProperties("plant_name", "String", "select_link_/GHServer/manager/plant/select", "required",null));
		}
	};
	
	public static final List<ModelProperties> device_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
		{
			add(new ModelProperties("id", "int", "ignore", "ignore",null));
			add(new ModelProperties("device_name", "String", "select_values_ESP32;LED;Pump A;Pump B;FAN;Pump ph up;Pump ph down;Pump up;Pump water", "requires",null));
		}
	};
	
	public static final List<ModelProperties> role_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("id", "int", "ignore", "ignore",null));
		add(new ModelProperties("role", "String", "select_link_/GHServer/manager/role/select", "required",null));
	}};
	
	public static final List<ModelProperties> log_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
		{
			add(new ModelProperties("id", "int", "ignore", "ignore",null));
			add(new ModelProperties("time", "String", "ignore", "ignore",null));
			add(new ModelProperties("auto", "boolean", "ignore", "ignore",null));
			add(new ModelProperties("statement", "Object", "object", "ignore",null));
			add(new ModelProperties("notification", "Object", "object", "ignore",null));
			add(new ModelProperties("frame", "Object", "object", "ignore",null));
			add(new ModelProperties("users", "Object", "object", "ignore",null));
		}
	};
	
	public static final List<ModelProperties> statement_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
		{
			add(new ModelProperties("id", "int", "ignore", "ignore",null));
			add(new ModelProperties("statements", "String", "ignore", "ignore",null));
			add(new ModelProperties("title", "String", "ignore", "ignore",null));
		}
	};
	
	public static final List<ModelProperties> notification_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
		{
			add(new ModelProperties("id", "int", "ignore", "ignore",null));
			add(new ModelProperties("notifications", "String", "ignore", "ignore",null));
		}
	};
	
	//filter list
	public static final List<ModelProperties> user_properties_filter = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("username","String",null));
		add(new ModelProperties("info.fullname", "String",null));
		add(new ModelProperties("info.email", "String",null));
		add(new ModelProperties("info.phone", "String",null));
		add(new ModelProperties("info.address", "String",null));
		add(new ModelProperties("info.date_of_birth", "String",null));
		add(new ModelProperties("info.gender", "boolean",null));
		add(new ModelProperties("role.role", "String",null));

	}};
	
	
	public static void updateItemOfSetFrame(Frame frame){
		set_frame.remove(frame);
		set_frame.add(frame);
	}
	
	public static Frame getItemFromSetFrame(int id){
		List<Frame> lis = new ArrayList<>(set_frame);
		for (int i = 0; i < lis.size(); i++) {
			if(lis.get(i).getId() == id)
				return lis.get(i);
		}
		return null;
	}
	
	public static Frame getItemFromSetFrameByControlId(int id){
		List<Frame> lis = new ArrayList<>(set_frame);
		for (int i = 0; i < lis.size(); i++) {
			if(lis.get(i).getDevice_control().getId() == id)
				return lis.get(i);
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static void stopThreadByDeviceId(int id){
		for (int i = 0; i < lis_deviceThread.size(); i++) {
			if(lis_deviceThread.get(i).getId() == id){
				for (int j = 0; j < lis_deviceThread.get(i).getLis().size(); j++) {
					System.out.println("stop" +i + "-" +j);
					lis_deviceThread.get(i).getLis().get(j).suspend();
				}
				System.out.println("thread : "+lis_deviceThread.get(i).getLis().size());
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void startThreadByDeviceId(int id){
		for (int i = 0; i < lis_deviceThread.size(); i++) {
			if(lis_deviceThread.get(i).getId() == id){
				for (int j = 0; j < lis_deviceThread.get(i).getLis().size(); j++) {
					System.out.println("start" +i + "-" +j);
					lis_deviceThread.get(i).getLis().get(j).resume();
				}
				System.out.println("thread : "+lis_deviceThread.get(i).getLis().size());
			}
		}
	}
	
	public static DeviceActive getDeviceActiveById(int id){
		List<DeviceActive> lis = new ArrayList<>(device_active);
		for (DeviceActive deviceActive : lis) {
			if(deviceActive.getId() == id)
				return deviceActive;
		}
		
		return null;
	}
	
}
