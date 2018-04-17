package vn.com.nct.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AvailableFrame")
public class AvailableFrame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "description" , nullable = true)
	private String description;
	
	@Column(name="image",nullable = true)
	private String image;
	
	@Column(name="status",nullable = false)
	private boolean status;
	
	@Column(name="control_device",nullable = false)
	private int control_device;
	
	@Column(name="collect_device",nullable = false)
	private int collect_device;
	
	@OneToMany(mappedBy = "available_frame")
	private List<Frame> frames;

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

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
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
