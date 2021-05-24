package homeworkDay5;

import homeworkDay5.business.abstracts.UserService;
import homeworkDay5.business.concretes.UserManager;
import homeworkDay5.core.concretes.EmailValidatorManager;
import homeworkDay5.core.concretes.InputVerification;
import homeworkDay5.core.concretes.JGoogleUserVerificationServiceAdepter;
import homeworkDay5.dataAccess.concretes.UserManagerDao;
import homeworkDay5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1= new User(1,"Melike","Öztekin","melike@melike.com","123456");
        User user2= new User(2,"K","Çakmak","kadriye@kadriye.com","123456");
		User user3= new User(3,"Busra","G","busra@busra.com","123456");
        User user4= new User(4,"Ceylan","Çokadar","ceylan@ceylan.com","12345");
        User user5 = new User(5,"Ýsmail","Hakký","ismail","123456");
        User user6 = new User(6,"Ýsmail","Hakký","melike@melike.com","123456");
        User user7 = new User(7,"Mehmet","Can","mehmet@mehmet.com","123456");

        UserService userService = new UserManager(new InputVerification(), new UserManagerDao(), new EmailValidatorManager());
        userService.register(user1);
        System.out.println("----------------------------------");
        userService.register(user2);
        System.out.println("----------------------------------");
        userService.register(user3);
        System.out.println("----------------------------------");
        userService.register(user4);
        System.out.println("----------------------------------");
        userService.register(user5);
        System.out.println("----------------------------------");
        userService.register(user6);
        System.out.println("----------------------------------");
        userService.delete("mehmet@mehmet.com","123456");
        System.out.println("----------------------------------");



        UserService userService2 = new UserManager(new JGoogleUserVerificationServiceAdepter(), new UserManagerDao(), new EmailValidatorManager());
        userService2.register(user1);
        
        System.out.println("----------------------------------");

        userService.login("busra@busra.com","123456");

        System.out.println("----------------------------------");

        userService.login ("melike@melike.com", "123456");
	}

}
