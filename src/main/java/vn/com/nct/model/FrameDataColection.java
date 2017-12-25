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

import vn.com.nct.constant.Constant;


@Entity
@Table(name = "FrameDataColection")
public class FrameDataColection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "frame")
	private Frame frame;
	
	@Column(name = "time", nullable = false)
	private String time;
	
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
	
	

	public FrameDataColection() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FrameDataColection(String msg) {
		super();
		
		// track message : token;temp;humid;co2;ph;water;time;
		String[] split = msg.split(Constant.SPLIT_PATTERN);
		
		this.setCo2(Double.parseDouble(split[3]));
		this.setHumidity(Double.parseDouble(split[2]));
		this.setpH(Double.parseDouble(split[4]));
		this.setTemperature(Double.parseDouble(split[1]));
		this.setWater(Boolean.parseBoolean(split[5]));
//		this.setTime(split[6]);
		
	}
	
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
