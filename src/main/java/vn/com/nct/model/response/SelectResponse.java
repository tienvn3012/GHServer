package vn.com.nct.model.response;

public class SelectResponse {
	private int id;
	private String value;
	
	
	
	public SelectResponse(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}
	public SelectResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
