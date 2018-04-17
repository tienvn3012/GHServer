package vn.com.nct.model.response;

import java.util.ArrayList;
import java.util.List;

public class TablePropertiesResponse extends PropertiesResponse{
	
	private List<ModelProperties> 		   display_left;
	private List<ModelProperties> 		   display_mid;
	private List<String> 				   display_right;
	
	
	public TablePropertiesResponse() {
		super();
		display_left 					= new ArrayList<>();
		display_mid 					= new ArrayList<>();
		display_right 					= new ArrayList<>();
	}
	
	public List<ModelProperties> getDisplay_left() {
		return display_left;
	}
	public void setDisplay_left(List<ModelProperties> display_left) {
		this.display_left = display_left;
	}
	public List<ModelProperties> getDisplay_mid() {
		return display_mid;
	}
	public void setDisplay_mid(List<ModelProperties> display_mid) {
		this.display_mid = display_mid;
	}
	public List<String> getDisplay_right() {
		return display_right;
	}
	public void setDisplay_right(List<String> display_right) {
		this.display_right = display_right;
	}

	
}
