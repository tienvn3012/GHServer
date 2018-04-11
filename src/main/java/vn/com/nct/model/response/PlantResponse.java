package vn.com.nct.model.response;

public class PlantResponse {
	
	private int 	id;
	private int 	time_harvest;
	private String 	plant_name;
	private String 	type_name;
	private String 	description;
	private String 	pH;
	private String 	co2;
	private String 	temperature;
	private String 	humidity;
	private String 	ec;
	private String 	light_time;
	private double	track_time;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTime_harvest() {
		return time_harvest;
	}
	public void setTime_harvest(int time_harvest) {
		this.time_harvest = time_harvest;
	}
	public String getPlant_name() {
		return plant_name;
	}
	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getpH() {
		return pH;
	}
	public void setpH(String pH) {
		this.pH = pH;
	}
	public String getCo2() {
		return co2;
	}
	public void setCo2(String co2) {
		this.co2 = co2;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getEc() {
		return ec;
	}
	public void setEc(String ec) {
		this.ec = ec;
	}
	public String getLight_time() {
		return light_time;
	}
	public void setLight_time(String light_time) {
		this.light_time = light_time;
	}
	public double getTrack_time() {
		return track_time;
	}
	public void setTrack_time(double track_time) {
		this.track_time = track_time;
	}
	
	
	
}
