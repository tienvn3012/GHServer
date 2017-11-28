package vn.com.nct.model.response;

public class UserInfoResponse {
	
	private int 	id;
	private int 	level;
	private String 	fullname;
	private String 	email;
	private String 	phone;
	private String 	address;
	private String 	date_of_birth;
	private boolean gender;
	
	
	
	public UserInfoResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoResponse(int id, int level, String fullname, String email, String phone, String address,
			String date_of_birth, boolean gender) {
		super();
		this.id = id;
		this.level = level;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	
	
}
