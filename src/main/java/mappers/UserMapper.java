package mappers;

import java.util.List;
import java.util.Map;

import model.User;

public interface UserMapper {
	List<User> getUserList(Map<String, Object> map);

	User getUserByLogin(Map<String, Object> map);

	User getUser(String uid);

	int existsUserName(String userName);

	void createUser(User user);

	void updateUser(User user);

	void updateUserPassword(Map<String, Object> map);

	void updateUserByDel(String uid);

	void deleteUser(String uid);
}
