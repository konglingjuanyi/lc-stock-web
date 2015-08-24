package biz.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.GroupInfoDao;
import model.GroupInfo;
import annotation.ITransactional;
import biz.GroupInfoBiz;

@Service
public class GroupInfoBizImpl implements GroupInfoBiz {

	@Resource
	private GroupInfoDao groupInfoDao;

	public List<GroupInfo> getGroupList(String name) {
		// TODO Auto-generated method stub
		return this.groupInfoDao.getGroupList(name);
	}

	public List<GroupInfo> getGroupListByParnet(String parentUid) {
		// TODO Auto-generated method stub
		return this.groupInfoDao.getGroupListByParnet(parentUid);
	}

	public GroupInfo getGroup(String uid) {
		// TODO Auto-generated method stub
		return this.groupInfoDao.getGroup(uid);
	}

	@ITransactional
	public void createGroup(GroupInfo group) {
		// TODO Auto-generated method stub
		group.setUid(UUID.randomUUID().toString());
		this.groupInfoDao.createGroup(group);
	}

	@ITransactional
	public void updateGroup(GroupInfo group) {
		// TODO Auto-generated method stub
		this.groupInfoDao.updateGroup(group);
	}

	@ITransactional
	public void deleteGroup(String uid) {
		// TODO Auto-generated method stub
		List<GroupInfo> list = this.getGroupList(null);
		List<String> uids = new ArrayList<String>();

		uids.add(uid);
		this.setGroup(list, uids, uid);

		for (String item : uids) {
			this.groupInfoDao.deleteGroup(item);
		}
	}

	private void setGroup(List<GroupInfo> list, List<String> uids,
			String parentuid) {
		for (GroupInfo item : list) {
			if (item.getParentUid().equals(parentuid)) {
				uids.add(item.getParentUid());
				this.setGroup(list, uids, item.getUid());
			}
		}
	}

}
