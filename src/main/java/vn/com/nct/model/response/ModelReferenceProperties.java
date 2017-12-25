package vn.com.nct.model.response;

import java.util.ArrayList;
import java.util.List;

public class ModelReferenceProperties {
	private String name;
	private List<ModelProperties> lis;
	
	
	
	public ModelReferenceProperties() {
		super();
		lis = new ArrayList<>();
	}
	public ModelReferenceProperties(String name, List<ModelProperties> lis) {
		super();
		this.name = name;
		this.lis = lis;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ModelProperties> getLis() {
		return lis;
	}
	public void setLis(List<ModelProperties> lis) {
		this.lis = lis;
	}
	
	
}
