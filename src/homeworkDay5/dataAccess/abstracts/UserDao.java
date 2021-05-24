package homeworkDay5.dataAccess.abstracts;

import homeworkDay5.entities.concretes.User;

public interface UserDao {
	void add(User user);
	boolean emailCheck(User user);
	boolean loginByCheck(String email, String password);
}
