package vn.com.nct.constant;

import java.util.ArrayList;
import java.util.List;

import vn.com.nct.model.DeviceThread;
import vn.com.nct.model.response.ModelProperties;

public class Constant {

	public static boolean AUTOMATIC_MODE = false; // ?
	
	
	// keep_alive_message : id;password;nct
	public static List<String> lis_keepAlive = new ArrayList<>();
	
	public static List<DeviceThread> lis_deviceThread = new ArrayList<>();
	/*
	 * condition standard : name_of_argument;value;compare;datatype
	 * plant param standad : min;max;time_min2;max2;time2
	 * if plant param not change in all life time : min;max;0
	 * time unit : default is 'day'
	 * 
	 * authentication message : id;password;type
	 * track message : token;temp;humid;co2;ph;water;time;
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
	public static final String PUMP_UP_ON 		= "PU_1\0";
	public static final String PUMP_DOWN_ON 	= "PD_1\0";
	
	public static final String LED_OFF  		= "L_0\0";
	public static final String FAN_OFF 			= "F_0\0";
	public static final String HEAT_LED_OFF 	= "HL_0\0";
	public static final String PUMP_A_OFF 		= "PA_0\0";
	public static final String PUMP_B_OFF 		= "PB_0\0";
	public static final String PUMP_UP_OFF 		= "PU_0\0";
	public static final String PUMP_DOWN_OFF 	= "PD_0\0";
	
	//model
	public static final List<ModelProperties> user_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("id", "int"));
		add(new ModelProperties("username","String"));
		add(new ModelProperties("avatar", "img"));
		add(new ModelProperties("info", "Object"));
		add(new ModelProperties("role", "Object"));
		add(new ModelProperties("create_by", "int"));
		add(new ModelProperties("create_time", "String"));
		add(new ModelProperties("last_login", "String"));
		add(new ModelProperties("active", "boolean"));
		add(new ModelProperties("create_to", "boolean"));
	}};
	
	public static final List<ModelProperties> info_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("id", "int"));
		add(new ModelProperties("level", "int"));
		add(new ModelProperties("fullname", "String"));
		add(new ModelProperties("email", "String"));
		add(new ModelProperties("phone", "String"));
		add(new ModelProperties("address", "String"));
		add(new ModelProperties("date_of_birth", "String"));
		add(new ModelProperties("gender", "boolean"));
	}};
	
	public static final List<ModelProperties> role_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("id", "int"));
		add(new ModelProperties("role", "String"));
	}};
	
	//filter list
	public static final List<ModelProperties> user_properties_filter = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("username","String"));
		add(new ModelProperties("info.fullname", "String"));
		add(new ModelProperties("info.email", "String"));
		add(new ModelProperties("info.phone", "String"));
		add(new ModelProperties("info.address", "String"));
		add(new ModelProperties("info.date_of_birth", "String"));
		add(new ModelProperties("info.gender", "boolean"));
		add(new ModelProperties("role.role", "String"));

	}};
}
