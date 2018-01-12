package vn.com.nct.model.response;

public class ModelProperties {
	
	private String name; // name of property
	
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
	
	public ModelProperties(String name, String type, String input, String rule, String notification) {
		super();
		this.name = name;
		this.type = type;
		this.input = input;
		this.rule = rule;
		this.notification = notification;
	}

	public ModelProperties(String name, String type, String input, String rule) {
		super();
		this.name = name;
		this.type = type;
		this.input = input;
		this.rule = rule;
	}

	
	public ModelProperties(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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
	
	
}
