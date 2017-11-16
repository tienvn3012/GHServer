package vn.com.nct.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Transient
	private String confirm;
	
	@Column(name = "active", nullable = false)
	private boolean active;
	
	@Column(name = "last_login")
	private String last_login;
	
	@Column(name = "create_by")
	private int create_by;
	
	@Column(name = "create_time" , nullable = false)
	private String create_time;
	
	@Column(name = "create_to")
	private boolean create_to;

	@Column(name = "deleted", nullable = false)
	private int deleted;
	
	@OneToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "info", nullable = false)
	private UserInfo info;
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	@JoinColumn(name = "role", nullable = false)
	private Roles role;
	
	@OneToMany(mappedBy = "users")
	private List<FrameUsers> frame_user;
	
	@OneToMany(mappedBy = "users")
	private List<SystemLogActivity> logs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getLast_login() {
		return last_login;
	}

	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	public int getCreate_by() {
		return create_by;
	}

	public void setCreate_by(int create_by) {
		this.create_by = create_by;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public boolean isCreate_to() {
		return create_to;
	}

	public void setCreate_to(boolean create_to) {
		this.create_to = create_to;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public UserInfo getInfo() {
		return info;
	}

	public void setInfo(UserInfo info) {
		this.info = info;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public List<FrameUsers> getFrame_user() {
		return frame_user;
	}

	public void setFrame_user(List<FrameUsers> frame_user) {
		this.frame_user = frame_user;
	}

	public List<SystemLogActivity> getLogs() {
		return logs;
	}

	public void setLogs(List<SystemLogActivity> logs) {
		this.logs = logs;
	}
	
	
}
