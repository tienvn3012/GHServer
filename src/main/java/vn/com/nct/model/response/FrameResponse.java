package vn.com.nct.model.response;

public class FrameResponse {
	
	private int id;
	private String time_begin;
	private boolean harvested;
	private boolean automatic_mode;
	private DevicesResponse device_cotrol;
	private DevicesResponse device_collect;
	private PlantResponse plant;
	

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

	public DevicesResponse getDevice_cotrol() {
		return device_cotrol;
	}

	public void setDevice_cotrol(DevicesResponse device_cotrol) {
		this.device_cotrol = device_cotrol;
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
	
	
	
}
