package vn.com.nct.model.response;

import java.util.ArrayList;
import java.util.List;

public class TablePropertiesResponse extends PropertiesResponse{

	private List<ModelProperties> display;

	public TablePropertiesResponse() {
		super();
		display = new ArrayList<ModelProperties>();
	}

	public List<ModelProperties> getDisplay() {
		return display;
	}

	public void setDisplay(List<ModelProperties> display) {
		this.display = display;
	}
	
	
	
}
