package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);



      Car car1 = new Car("sss1","1");
      Car car2 = new Car("sss2","2");
      Car car3 = new Car("sss3","3");
      User user1 = new User("User111sss", "Lastname111", "user111@mail.ru",car1);
      User user2 = new User("User12sss", "Lastname1211", "user1211@mail.ru",car2);
      User user3 = new User("User131sss", "Lastname1311", "user1311@mail.ru",car3);
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Model = "+user.getUserCar().getModel());
         System.out.println("Series = "+user.getUserCar().getSeries());
         System.out.println();
      }


      System.out.println(userService.getUserByCar("Tesla3", "Model3"));

      context.close();
   }
}
