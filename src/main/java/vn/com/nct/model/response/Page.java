package vn.com.nct.model.response;

import java.util.List;

public class Page <E>{
	
	private int page_number;
	private int total_page;
	private int row;
	private int role;
	private List<E> lis;
	
	
	public int getPage_number() {
		return page_number;
	}
	public void setPage_number(int page_number) {
		this.page_number = page_number;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public List<E> getLis() {
		return lis;
	}
	public void setLis(List<E> lis) {
		this.lis = lis;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}
	
	
}
