package vn.com.nct.model.response;

public class ModelProperties {
	
	private String name; // name of property
	
	private String icon;
	
	private String display_name;
	
	// type : object,img,String,int,double,...
	private String type; 
	
	// input_type : ignore,object,img,inputtext,select_{type(values|link)}_{values(v1;v2;...)|link},
	//radio_{type(values|link)}_{values(v1;v2;...)|link},checkbox_{type(values|link)}_{values(v1;v2;...)|link}
	private String input;
	
	// rule : ignore,required,notrequired,number,minlength_{number},maxlength_{number},nothave_{p1;p2;...}
	private String rule; 
	
	// dd/mm/yyyy, min, max .... just for placeholder
	private String notification;
	
	
	public ModelProperties() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ModelProperties(String name, String type, String input, String rule, String notification, String icon) {
		super();
		this.name = name;
		this.type = type;
		this.input = input;
		this.rule = rule;
		this.notification = notification;
		this.icon = icon;
	}

	public ModelProperties(String name, String type, String input, String rule, String icon) {
		super();
		this.name = name;
		this.type = type;
		this.input = input;
		this.rule = rule;
		this.icon = icon;
	}

	
	public ModelProperties(String name, String type, String icon) {
		super();
		this.name = name;
		this.type = type;
		this.icon = icon;
	}
	
	public ModelProperties(String name, String type, String icon, String display_name) {
		super();
		this.name = name;
		this.type = type;
		this.icon = icon;
		this.display_name = display_name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	
	
}
