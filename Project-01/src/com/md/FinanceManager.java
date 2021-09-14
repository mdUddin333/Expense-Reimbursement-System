package com.md;

public class FinanceManager{

	private int Id;
	private String username;
	private String password;
	
	public FinanceManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FinanceManager(int id, String username, String password) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	@Override
	public String toString() {
		return "FinanceManager [Id=" + Id + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
