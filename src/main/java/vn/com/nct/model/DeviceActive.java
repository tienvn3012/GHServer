package vn.com.nct.model;

import java.util.List;

public class DeviceActive {
	
	private int id;
	private List<DeviceStage> lis;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<DeviceStage> getLis() {
		return lis;
	}
	public void setLis(List<DeviceStage> lis) {
		this.lis = lis;
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
		DeviceActive other = (DeviceActive) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
