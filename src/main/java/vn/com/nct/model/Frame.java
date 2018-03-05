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
	
	@Column(name = "harvested", nullable = false)
	private boolean harvested;
	
	@Column(name = "automatic_mode",nullable = false)
	private boolean automatic_mode;
	
	@OneToMany(mappedBy = "frame")
	private List<FrameDataColection> frame_data;

	@OneToMany(mappedBy = "frame")
	private List<FrameUsers> frame_users;
	
	@OneToMany(mappedBy = "frame")
	private List<SystemLogActivity> logs;

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

	public boolean isHarvested() {
		return harvested;
	}

	public void setHarvested(boolean harvested) {
		this.harvested = harvested;
	}

	public List<FrameDataColection> getFrame_data() {
		return frame_data;
	}

	public void setFrame_data(List<FrameDataColection> frame_data) {
		this.frame_data = frame_data;
	}

	public List<FrameUsers> getFrame_users() {
		return frame_users;
	}

	public void setFrame_users(List<FrameUsers> frame_users) {
		this.frame_users = frame_users;
	}

	public List<SystemLogActivity> getLogs() {
		return logs;
	}

	public void setLogs(List<SystemLogActivity> logs) {
		this.logs = logs;
	}

	public boolean isAutomatic_mode() {
		return automatic_mode;
	}

	public void setAutomatic_mode(boolean automatic_mode) {
		this.automatic_mode = automatic_mode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frame other = (Frame) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
}
