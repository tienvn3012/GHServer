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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Plants")
public class Plants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "plant_name",nullable = false)
	private String plant_name;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "plant_type")
	private PlantType plant_type;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "plant_info")
	private PlantInfo plant_info;
	
	@OneToMany(mappedBy = "plant")
	private List<Frame> frames;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlant_name() {
		return plant_name;
	}

	public void setPlant_name(String plant_name) {
		this.plant_name = plant_name;
	}

	public PlantType getPlant_type() {
		return plant_type;
	}

	public void setPlant_type(PlantType plant_type) {
		this.plant_type = plant_type;
	}

	public PlantInfo getPlant_info() {
		return plant_info;
	}

	public void setPlant_info(PlantInfo plant_info) {
		this.plant_info = plant_info;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
	
	
}
