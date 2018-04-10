package vn.com.nct.model.response;

public class DevicesResponse {
	
	private int id;
	private String device_name;
	private int control_device;
	private boolean device_task;
	private boolean device_status;
	private String description;
	private String type_name;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDevice_name() {
		return device_name;
	}
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
	}
	public int getControl_device() {
		return control_device;
	}
	public void setControl_device(int control_device) {
		this.control_device = control_device;
	}
	public boolean isDevice_task() {
		return device_task;
	}
	public void setDevice_task(boolean device_task) {
		this.device_task = device_task;
	}
	public boolean isDevice_status() {
		return device_status;
	}
	public void setDevice_status(boolean device_status) {
		this.device_status = device_status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	
}
