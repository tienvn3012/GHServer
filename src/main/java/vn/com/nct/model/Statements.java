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
@Table(name = "Statements")
public class Statements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "statements", nullable = false,unique = true)
	private String statements;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@OneToMany(mappedBy = "statements")
	private List<SystemLog> logs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatements() {
		return statements;
	}

	public void setStatements(String statements) {
		this.statements = statements;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<SystemLog> getLogs() {
		return logs;
	}

	public void setLogs(List<SystemLog> logs) {
		this.logs = logs;
	}
	
	
}
