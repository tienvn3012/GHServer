package vn.com.nct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PlantType")
public class PlantType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "type_name",nullable = false)
	private String type_name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "plant_type")
	private Plants plant;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Plants getPlant() {
		return plant;
	}

	public void setPlant(Plants plant) {
		this.plant = plant;
	}
	
	
}
