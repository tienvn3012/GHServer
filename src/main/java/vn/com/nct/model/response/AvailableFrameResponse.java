package vn.com.nct.model.response;

public class AvailableFrameResponse {
	
	private int id;
	private String description;
	private String image;
	private boolean status;
	private int control_device;
	private int collect_device;
	
	
	
	public AvailableFrameResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AvailableFrameResponse(int id, String description, String image, boolean status, int control_device,
			int collect_device) {
		super();
		this.id = id;
		this.description = description;
		this.image = image;
		this.status = status;
		this.control_device = control_device;
		this.collect_device = collect_device;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getControl_device() {
		return control_device;
	}
	public void setControl_device(int control_device) {
		this.control_device = control_device;
	}
	public int getCollect_device() {
		return collect_device;
	}
	public void setCollect_device(int collect_device) {
		this.collect_device = collect_device;
	}
	
	
	
}
