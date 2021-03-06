package vn.com.nct.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SystemLogActivity")
public class SystemLogActivity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "time", nullable = false)
	private String time;
	
	@Column(name = "auto", nullable = false)
	private boolean auto;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "statements")
	private Statements statements;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "notification")
	private Notifications notification;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "frame")
	private Frame frame;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "users")
	private Users users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isAuto() {
		return auto;
	}

	public void setAuto(boolean auto) {
		this.auto = auto;
	}

	public Statements getStatements() {
		return statements;
	}

	public void setStatements(Statements statements) {
		this.statements = statements;
	}

	public Notifications getNotification() {
		return notification;
	}

	public void setNotification(Notifications notification) {
		this.notification = notification;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
	
}
