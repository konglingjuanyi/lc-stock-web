package biz;

import java.util.List;
import model.User;

public interface UserBiz {
	List<User> getUserList(String userName,String name);
	User login(String userName,String password);
	User getUser(String uid);
	void createUser(User user);
	void updateUser(User user);
	void updateUserPassword(String uid,String password);
	void deleteUser(String uid);
}
