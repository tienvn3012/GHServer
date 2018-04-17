package vn.com.nct.model.response;

import java.util.ArrayList;
import java.util.List;

public class BlockPropertiesResponse extends PropertiesResponse{
	
	private String img;
	private List<ModelProperties> display;
	private List<ModelProperties> actions;
	
	
	
	public BlockPropertiesResponse() {
		super();
		display = new ArrayList<>();
		actions = new ArrayList<>();
		
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public List<ModelProperties> getDisplay() {
		return display;
	}
	public void setDisplay(List<ModelProperties> display) {
		this.display = display;
	}
	public List<ModelProperties> getActions() {
		return actions;
	}
	public void setActions(List<ModelProperties> actions) {
		this.actions = actions;
	}
	
	
	
}
