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
@Table(name = "DeviceType")
public class DeviceType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; //1:ESP; 2:LED; 3:FAN; 4:Pump A; 5:Pump B; 6:Pump Up; 7:Pump Down 
	
	@Column(name = "type_name",nullable = false)
	private String type_name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(mappedBy = "device_type")
	private List<Devices> devices;

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

	public List<Devices> getDevices() {
		return devices;
	}

	public void setDevices(List<Devices> devices) {
		this.devices = devices;
	}
	
	
}
