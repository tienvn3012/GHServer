package vn.com.nct.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Notifications")
public class Notifications {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "notifications", nullable = false,unique = true)
	private String notifications;
	
	@OneToMany(mappedBy = "notification")
	private List<SystemLogActivity> logs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	public List<SystemLogActivity> getLogs() {
		return logs;
	}

	public void setLogs(List<SystemLogActivity> logs) {
		this.logs = logs;
	}
	
	
}
