package shiro;

import java.io.Serializable;
import java.util.List;

public class WebUser implements Serializable {

	private static final long serialVersionUID = -5311350500778209368L;

	private String uid;
	private String username;
	private String name;
	private String phone;
	private boolean isAdmin;
	private boolean isCustomer;
	
	private List<Groups> userGroups;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isCustomer() {
		return isCustomer;
	}

	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public List<Groups> getUserGroups() {
		return userGroups;
	}

	public void setUserGroups(List<Groups> userGroups) {
		this.userGroups = userGroups;
	}
	
	
}
