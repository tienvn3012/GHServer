package vn.com.nct.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Frame")
public class Frame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "plant", nullable = false)
	private Plants plant;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "device_control")
	private Devices device_control;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "device_colect")
	private Devices device_colect;
	
	@Column(name = "time_begin", nullable = false)
	private String time_begin;
	
	@OneToMany(mappedBy = "frame")
	private List<FrameData> frame_data;

	@OneToMany(mappedBy = "frame")
	private List<FrameUsers> frame_users;
	
	@OneToMany(mappedBy = "frame")
	private List<SystemLog> logs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Plants getPlant() {
		return plant;
	}

	public void setPlant(Plants plant) {
		this.plant = plant;
	}

	public Devices getDevice_control() {
		return device_control;
	}

	public void setDevice_control(Devices device_control) {
		this.device_control = device_control;
	}

	public Devices getDevice_colect() {
		return device_colect;
	}

	public void setDevice_colect(Devices device_colect) {
		this.device_colect = device_colect;
	}

	public String getTime_begin() {
		return time_begin;
	}

	public void setTime_begin(String time_begin) {
		this.time_begin = time_begin;
	}

	public List<FrameData> getFrame_data() {
		return frame_data;
	}

	public void setFrame_data(List<FrameData> frame_data) {
		this.frame_data = frame_data;
	}

	public List<FrameUsers> getFrame_users() {
		return frame_users;
	}

	public void setFrame_users(List<FrameUsers> frame_users) {
		this.frame_users = frame_users;
	}

	public List<SystemLog> getLogs() {
		return logs;
	}

	public void setLogs(List<SystemLog> logs) {
		this.logs = logs;
	}
	
	
	
}
