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
@Table(name = "Devices")
public class Devices {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "device_name", nullable = false)
	private String device_name;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	// false : collect; true : control
	@Column(name = "device_task", nullable = false)
	private boolean device_task;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "device_type")
	private DeviceType device_type;
	
	@OneToMany(mappedBy = "device_control")
	private List<Frame> frames_control;

	@OneToMany(mappedBy = "device_colect")
	private List<Frame> frames_colect;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isDevice_task() {
		return device_task;
	}

	public void setDevice_task(boolean device_task) {
		this.device_task = device_task;
	}

	public DeviceType getDevice_type() {
		return device_type;
	}

	public void setDevice_type(DeviceType device_type) {
		this.device_type = device_type;
	}

	public List<Frame> getFrames_control() {
		return frames_control;
	}

	public void setFrames_control(List<Frame> frames_control) {
		this.frames_control = frames_control;
	}

	public List<Frame> getFrames_colect() {
		return frames_colect;
	}

	public void setFrames_colect(List<Frame> frames_colect) {
		this.frames_colect = frames_colect;
	}
	
	
}
