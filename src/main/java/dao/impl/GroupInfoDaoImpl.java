package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import mappers.GroupInfoMapper;
import model.GroupInfo;
import dao.GroupInfoDao;

@Repository
public class GroupInfoDaoImpl implements GroupInfoDao {

	@Resource
	private GroupInfoMapper groupInfoMapper;

	public List<GroupInfo> getGroupList(String name) {
		// TODO Auto-generated method stub
		if (name == null || name.equals(""))
			name = "";
		String p = "%" + name + "%";
		return this.groupInfoMapper.getGroupList(p);
	}

	public List<GroupInfo> getGroupListByParnet(String parentUid) {
		// TODO Auto-generated method stub
		return this.groupInfoMapper.getGroupListByParnet(parentUid);
	}

	public GroupInfo getGroup(String uid) {
		// TODO Auto-generated method stub
		return this.groupInfoMapper.getGroup(uid);
	}

	public void createGroup(GroupInfo group) {
		// TODO Auto-generated method stub
		this.groupInfoMapper.createGroup(group);
	}

	public void updateGroup(GroupInfo group) {
		// TODO Auto-generated method stub
		this.groupInfoMapper.updateGroup(group);
	}

	public void deleteGroup(String uid) {
		// TODO Auto-generated method stub
		this.groupInfoMapper.deleteGroup(uid);
	}

}
