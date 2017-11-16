package vn.com.nct.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FrameData")
public class FrameData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "frame")
	private Frame frame;
	
	@Column(name = "current_time", nullable = false)
	private String current_time;
	
	@Column(name = "pH", nullable = false)
	private double pH;
	
	@Column(name = "co2", nullable = false)
	private double co2;
	
	@Column(name = "temperature", nullable = false)
	private double temperature;
	
	@Column(name = "humidity", nullable = false)
	private double humidity;
	
	@Column(name = "water", nullable = false)
	private boolean water;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public String getCurrent_time() {
		return current_time;
	}

	public void setCurrent_time(String current_time) {
		this.current_time = current_time;
	}

	public double getpH() {
		return pH;
	}

	public void setpH(double pH) {
		this.pH = pH;
	}

	public double getCo2() {
		return co2;
	}

	public void setCo2(double co2) {
		this.co2 = co2;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}
	
	
	
}
