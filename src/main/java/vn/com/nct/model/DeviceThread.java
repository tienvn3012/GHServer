package vn.com.nct.model;

import java.util.ArrayList;
import java.util.List;

public class DeviceThread {
	private int id;
	private List<Thread> lis;
	
	public DeviceThread() {
		super();
		lis = new ArrayList<>();
	}
	
	
	
	public DeviceThread(int id) {
		super();
		this.id = id;
		lis = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Thread> getLis() {
		return lis;
	}
	public void setLis(List<Thread> lis) {
		this.lis = lis;
	}
	
	
}
