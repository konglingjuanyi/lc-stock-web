package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import mappers.UserMapper;
import model.User;
import dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Resource
	private UserMapper userMapper;

	public List<User> getUserList(String userName, String name) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("name", name);

		return this.userMapper.getUserList(map);
	}

	public User getUserByLogin(String userName, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("password", password);
		return this.userMapper.getUserByLogin(map);
	}

	public User getUser(String uid) {
		// TODO Auto-generated method stub
		return this.userMapper.getUser(uid);
	}

	public int existsUserName(String userName) {
		// TODO Auto-generated method stub
		return this.userMapper.existsUserName(userName);
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		this.userMapper.createUser(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		this.userMapper.updateUser(user);
	}

	public void updateUserPassword(String uid, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", uid);
		map.put("password", password);
		this.userMapper.updateUserPassword(map);
	}

	public void updateUserByDel(String uid) {
		// TODO Auto-generated method stub
		this.userMapper.updateUserByDel(uid);
	}

	public void deleteUser(String uid) {
		// TODO Auto-generated method stub
		this.userMapper.deleteUser(uid);
	}

}
