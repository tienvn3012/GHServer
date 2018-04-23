package vn.com.nct.model.response;

public class LogResponse {
	private int id;
	private String time;
	private boolean auto;
	private StatementResponse statement;
	private NotificationResponse notification;
	private FrameResponse frame;
	private UserResponse users;
	
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
	public StatementResponse getStatement() {
		return statement;
	}
	public void setStatement(StatementResponse statement) {
		this.statement = statement;
	}
	public NotificationResponse getNotification() {
		return notification;
	}
	public void setNotification(NotificationResponse notification) {
		this.notification = notification;
	}
	public FrameResponse getFrame() {
		return frame;
	}
	public void setFrame(FrameResponse frame) {
		this.frame = frame;
	}
	public UserResponse getUsers() {
		return users;
	}
	public void setUsers(UserResponse users) {
		this.users = users;
	}
	
	
	
}
