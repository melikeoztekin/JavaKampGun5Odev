package homeworkDay5.core.concretes;

import java.util.regex.Pattern;

import homeworkDay5.core.abstracts.VerificationService;
import homeworkDay5.entities.concretes.User;


public class InputVerification implements VerificationService{
	public boolean isValidEmail(String email) {
        String emailRegex ="^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    public boolean isValidPassword(String password) {
        if (password == null||password.length() < 6) {
            return false;
        }

        return true;
    }


    public boolean isValidString(String name) {

        if (name == null ||name.length() < 2) {
            return false;
        }
        for (char c : name.toCharArray()) {
            if (Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValid(User user) {
    	if (isValidEmail(user.geteMail())) {
			if (user.getFirstName().length() >= 2) {
				if (user.getLastName().length() >= 2) {
					if (user.getPassword().length() >= 6) {
						return true;
					} else {
						System.out.println("Parola en az 6 karakter olmalý. "+user.getFirstName()+ " "+user.getLastName());
						return false;
					}
				} else {
					System.out.println("Kullanýcý soyadý en az 2 karakter olmalý.");
					return false;
				}
			} else {
				System.out.println("Kullanýcý adý en az 2 karakter olmalý.");
				return false;
			}
		} else {
			System.out.println("Geçerli bir mail adresi giriniz.");
			return false;
		}

    }

}