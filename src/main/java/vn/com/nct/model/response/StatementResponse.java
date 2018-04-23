package vn.com.nct.model.response;

public class StatementResponse {
	private int id;
	private String statements;
	private String title;
	
	
	
	public StatementResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StatementResponse(int id, String statements, String title) {
		super();
		this.id = id;
		this.statements = statements;
		this.title = title;
	}

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
	
	
}
