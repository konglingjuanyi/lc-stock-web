package dao;

import java.util.List;

import model.GroupInfo;

public interface GroupInfoDao {
	List<GroupInfo> getGroupList(String name);

	List<GroupInfo> getGroupListByParnet(String parentUid);

	GroupInfo getGroup(String uid);

	void createGroup(GroupInfo group);

	void updateGroup(GroupInfo group);

	void deleteGroup(String uid);
}
