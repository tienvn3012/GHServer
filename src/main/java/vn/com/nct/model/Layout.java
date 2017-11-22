package vn.com.nct.model;

public class Layout {
	
	private String layout;
	private String path;

	public Layout() {
		super();
	}
	public Layout(String layout, String path) {
		super();
		this.layout = layout;
		this.path = path;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
