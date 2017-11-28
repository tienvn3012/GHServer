package vn.com.nct.model.response;

public class RoleResponse {
	
	private int id;
	private String role;
	
	
	
	public RoleResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RoleResponse(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
