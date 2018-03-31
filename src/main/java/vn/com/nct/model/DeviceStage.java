package vn.com.nct.model;

public class DeviceStage {
	
	private int id;
	private String name;
	private boolean stage;
	
	
	
	public DeviceStage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DeviceStage(int id, String name, boolean stage) {
		super();
		this.id = id;
		this.name = name;
		this.stage = stage;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStage() {
		return stage;
	}
	public void setStage(boolean stage) {
		this.stage = stage;
	}
	
	
	
}
