package vn.com.nct.model.response;

import java.util.ArrayList;
import java.util.List;

public class PropertiesResponse {
	private int 						   total_records;
	private String 						   base_url;
	private String 						   link_url;
	private String						   name;
	private List<ModelProperties>		   model_properties;
	private List<ModelReferenceProperties> lis_model_reference_properties;
	private List<ModelProperties> 		   model_properties_filter;
	private List<ModelProperties> 		   display_left;
	private List<ModelProperties> 		   display_mid;
	private List<String> 				   display_right;

	
	
	
	public PropertiesResponse() {
		super();
		model_properties 				= new ArrayList<>();
		model_properties_filter			= new ArrayList<>();
		lis_model_reference_properties  = new ArrayList<>();
		display_left 					= new ArrayList<>();
		display_mid 					= new ArrayList<>();
		display_right 					= new ArrayList<>();
	}
	
	public List<ModelProperties> getModel_properties() {
		return model_properties;
	}
	public void setModel_properties(List<ModelProperties> model_properties) {
		this.model_properties = model_properties;
	}
	public List<ModelReferenceProperties> getLis_model_reference_properties() {
		return lis_model_reference_properties;
	}
	public void setLis_model_reference_properties(List<ModelReferenceProperties> lis_model_reference_properties) {
		this.lis_model_reference_properties = lis_model_reference_properties;
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

	public int getTotal_records() {
		return total_records;
	}

	public void setTotal_records(int total_records) {
		this.total_records = total_records;
	}

	public List<ModelProperties> getModel_properties_filter() {
		return model_properties_filter;
	}

	public void setModel_properties_filter(List<ModelProperties> model_properties_filter) {
		this.model_properties_filter = model_properties_filter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBase_url() {
		return base_url;
	}

	public void setBase_url(String base_url) {
		this.base_url = base_url;
	}

	public String getLink_url() {
		return link_url;
	}

	public void setLink_url(String link_url) {
		this.link_url = link_url;
	}

	
	
}
