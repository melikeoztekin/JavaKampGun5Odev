package homeworkDay5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import homeworkDay5.dataAccess.abstracts.UserDao;
import homeworkDay5.entities.concretes.User;

public class UserManagerDao implements UserDao{

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " Sisteme kaydedildi.");
	}

	@Override
	public boolean emailCheck(User user) {
		for (User u : users)
			if (u.geteMail() == user.geteMail()) {
				return false;
			}
		return true;
	}

	@Override
	public boolean loginByCheck(String eMail, String password) {
		for (User user : users) {
			if (user.geteMail() == eMail && user.getPassword() == password) {
				return true;
			}
		}
		return false;
	}

}