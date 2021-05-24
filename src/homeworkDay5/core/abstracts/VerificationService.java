package homeworkDay5.core.abstracts;

import homeworkDay5.entities.concretes.User;

public interface VerificationService {
	boolean isValid(User user);
	}
