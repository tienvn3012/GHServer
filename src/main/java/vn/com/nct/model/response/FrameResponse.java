package vn.com.nct.model.response;

public class FrameResponse {
	
	private int id;
	private int days;
	private String time_begin;
	private boolean harvested;
	private boolean automatic_mode;
	private DevicesResponse device_control;
	private DevicesResponse device_collect;
	private PlantResponse plant;
	private AvailableFrameResponse available_frame;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(String time_begin) {
		this.time_begin = time_begin;
	}

	public boolean isHarvested() {
		return harvested;
	}

	public void setHarvested(boolean harvested) {
		this.harvested = harvested;
	}

	public boolean isAutomatic_mode() {
		return automatic_mode;
	}

	public void setAutomatic_mode(boolean automatic_mode) {
		this.automatic_mode = automatic_mode;
	}

	public DevicesResponse getDevice_control() {
		return device_control;
	}

	public void setDevice_control(DevicesResponse device_control) {
		this.device_control = device_control;
	}

	public DevicesResponse getDevice_collect() {
		return device_collect;
	}

	public void setDevice_collect(DevicesResponse device_collect) {
		this.device_collect = device_collect;
	}

	public PlantResponse getPlant() {
		return plant;
	}

	public void setPlant(PlantResponse plant) {
		this.plant = plant;
	}

	public AvailableFrameResponse getAvailable_frame() {
		return available_frame;
	}

	public void setAvailable_frame(AvailableFrameResponse available_frame) {
		this.available_frame = available_frame;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	
	
}
