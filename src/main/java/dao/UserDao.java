package dao;

import java.util.List;

import model.User;

public interface UserDao {
	List<User> getUserList(String userName, String name);

	User getUserByLogin(String userName, String password);

	User getUser(String uid);

	int existsUserName(String userName);

	void createUser(User user);

	void updateUser(User user);

	void updateUserPassword(String uid, String password);

	void updateUserByDel(String uid);

	void deleteUser(String uid);
}
