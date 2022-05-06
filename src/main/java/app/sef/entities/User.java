package app.sef.entities;

public class User {
	private String username;
	private String password;
	private String country;
	private String key;
	
	public String getUserName() {
		return username;
	}

	public void setUserName(String name) {
		this.username = username;
	}
	
	public String getPwd() {
		return password;
	}

	public void setPwd(String name) {
		this.password = password;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String name) {
		this.country = country;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String name) {
		this.key = key;
	}
}
