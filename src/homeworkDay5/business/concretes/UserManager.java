package homeworkDay5.business.concretes;


import homeworkDay5.business.abstracts.UserService;
import homeworkDay5.core.abstracts.ValidatorService;
import homeworkDay5.core.abstracts.VerificationService;
import homeworkDay5.dataAccess.abstracts.UserDao;
import homeworkDay5.entities.concretes.User;

public class UserManager implements UserService {

	VerificationService memberInformationValidation;
	UserDao userDao;
	ValidatorService validatorService;
	
	public UserManager(VerificationService memberInformationValidation, UserDao userDao,
			ValidatorService validatorService) {
		super();
		this.memberInformationValidation = memberInformationValidation;
		this.userDao = userDao;
		this.validatorService = validatorService;
	}
	
	@Override
	public void register(User user) {
		if (!memberInformationValidation.isValid(user) ) {
			System.out.println("Lütfen alanlarý belirtildiði biçimde doldurunuz.");
		}else if(!userDao.emailCheck(user)) {
			System.out.println("Bu email adresi daha önce alýnmýþ = "+user.geteMail()+"\n"+"Kayýt iþlemi baþarýsýz..");
		}else{
			userDao.add(user);
			validatorService.sendVerificationMail();
		}
	}

	@Override
	public void login(String eMail, String password) {
		if (userDao.loginByCheck(eMail, password)) {
			System.out.println("Giriþ baþarýlý " +eMail);
			
		}else {
			System.out.println("Kullanýcý bilgileri hatalý " +eMail);
		}
	}

	@Override
	public void delete(String eMail, String password) {
		System.out.println("Kullanýcý kaydý silindi : " +eMail );
		
	}
	

}