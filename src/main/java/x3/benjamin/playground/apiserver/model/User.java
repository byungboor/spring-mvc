package x3.benjamin.playground.apiserver.model;

/**
 * Created by benjamin on 2017. 2. 14..
 */

public class User {
	private Long userId;
	private String name;
	private String address;

	public User(Long userId, String name, String address) {
		this.setUserId(userId);
		this.setName(name);
		this.setAddress(address);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
