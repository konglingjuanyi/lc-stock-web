package shiro;

import java.io.Serializable;
import java.util.List;

public class Groups implements Serializable {

	private static final long serialVersionUID = -4944779638387478228L;

	private String uid;
	private String groupName;
	private boolean isAdmin;
	private String parentUid;

	private List<Groups> children;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getParentUid() {
		return parentUid;
	}

	public void setParentUid(String parentUid) {
		this.parentUid = parentUid;
	}

	public List<Groups> getChildren() {
		return children;
	}

	public void setChildren(List<Groups> children) {
		this.children = children;
	}

}
