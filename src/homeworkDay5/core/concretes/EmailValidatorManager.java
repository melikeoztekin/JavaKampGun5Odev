package homeworkDay5.core.concretes;

import homeworkDay5.core.abstracts.ValidatorService;

public class EmailValidatorManager implements ValidatorService {

	@Override
	public void sendVerificationMail() {
		System.out.println("Mail adresinize doðrulama e-postasý gönderildi. ");
	}
}