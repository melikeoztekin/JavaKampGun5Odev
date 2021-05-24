package homeworkDay5.core.concretes;

import homeworkDay5.core.abstracts.VerificationService;
import homeworkDay5.entities.concretes.User;
import homeworkDay5.jGoogle.JGoogleUserIsvalid;

public class JGoogleUserVerificationServiceAdepter implements VerificationService {

	@Override
	public boolean isValid(User user) {
		JGoogleUserIsvalid googleValid=new JGoogleUserIsvalid();
		return googleValid.isValid();
	}
}