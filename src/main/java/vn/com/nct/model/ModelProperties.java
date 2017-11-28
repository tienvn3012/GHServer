package vn.com.nct.model;

public class ModelProperties {
	private String name;
	private String type;
	
	
	
	public ModelProperties() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
