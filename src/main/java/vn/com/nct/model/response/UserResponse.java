package vn.com.nct.model.response;

public class UserResponse {
	
	private int 			 id;
	private int 			 create_by;
	private String 			 username;
	private String 			 create_time;
	private String 			 last_login;
	private String			 avatar;
	private boolean 		 active;
	private boolean 		 create_to;
	private boolean			 state; //1 : existed, 2
	private RoleResponse 	 role;
	private UserInfoResponse info;
	
	
	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCreate_by() {
		return create_by;
	}
	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isCreate_to() {
		return create_to;
	}
	public void setCreate_to(boolean create_to) {
		this.create_to = create_to;
	}
	public RoleResponse getRole() {
		return role;
	}
	public void setRole(RoleResponse role) {
		this.role = role;
	}
	public UserInfoResponse getInfo() {
		return info;
	}
	public void setInfo(UserInfoResponse info) {
		this.info = info;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	
}
