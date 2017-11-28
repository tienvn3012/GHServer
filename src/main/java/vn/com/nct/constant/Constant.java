package vn.com.nct.constant;

import java.util.ArrayList;
import java.util.List;

import vn.com.nct.model.ModelProperties;

public class Constant {

	/*
	 * condition standard : name_of_argument;value;compare 
	 */
	public static final String SPLIT_PATTERN = ";";
	
	// Control syntax
	public static final String LED_ON 	= "L_1";
	public static final String LED_OFF  = "L_0";
	
	//model
	public static final List<ModelProperties> user_properties = new ArrayList<ModelProperties>(){
		private static final long serialVersionUID = 1L;
	{
		add(new ModelProperties("id", "int"));
		add(new ModelProperties("username","String"));
		add(new ModelProperties("avatar", "img"));
		add(new ModelProperties("info", "Object"));
		add(new ModelProperties("role", "Object"));
		add(new ModelProperties("create_by", "String"));
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
}
