package vn.com.nct.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PlantInfo")
public class PlantInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "pH", nullable = false)
	private String pH;
	
	
	@Column(name = "co2", nullable = false)
	private String co2;
	
	@Column(name = "temperature", nullable = false)
	private String temperature;
	
	@Column(name = "humidity", nullable = false)
	private String humidity;
	
	@Column(name = "ec", nullable = false)
	private String ec;
	
	@Column(name = "light_time", nullable = false)
	private String light_time;
	
	@Column(name = "time_harvest")
	private int time_harvest;
	
	@Column(name="track_time")
	private double track_time;
	
	@OneToOne(mappedBy = "plant_info", cascade = CascadeType.PERSIST)
	private Plants plant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Plants getPlant() {
		return plant;
	}

	public void setPlant(Plants plant) {
		this.plant = plant;
	}

	public int getTime_harvest() {
		return time_harvest;
	}

	public void setTime_harvest(int time_harvest) {
		this.time_harvest = time_harvest;
	}

	public double getTrack_time() {
		return track_time;
	}

	public void setTrack_time(double track_time) {
		this.track_time = track_time;
	}
	
	
}
