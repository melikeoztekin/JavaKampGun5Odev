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
			System.out.println("L�tfen alanlar� belirtildi�i bi�imde doldurunuz.");
		}else if(!userDao.emailCheck(user)) {
			System.out.println("Bu email adresi daha �nce al�nm�� = "+user.geteMail()+"\n"+"Kay�t i�lemi ba�ar�s�z..");
		}else{
			userDao.add(user);
			validatorService.sendVerificationMail();
		}
	}

	@Override
	public void login(String eMail, String password) {
		if (userDao.loginByCheck(eMail, password)) {
			System.out.println("Giri� ba�ar�l� " +eMail);
			
		}else {
			System.out.println("Kullan�c� bilgileri hatal� " +eMail);
		}
	}

	@Override
	public void delete(String eMail, String password) {
		System.out.println("Kullan�c� kayd� silindi : " +eMail );
		
	}
	

}