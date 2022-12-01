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

         userService.add(new User("Ivan", "Ivanov", (byte) 36,  "ivan@mail.ru")
                 .setCar(new Car("Audi R8", 34634)));
         userService.add(new User("Olga", "Popova", (byte) 45, "olga@mail.ru")
                 .setCar(new Car("Audi TT", 363)));
         userService.add(new User("Petr", "Glebov", (byte) 32, "petr3@mail.ru")
                 .setCar(new Car("Carra GS7", 4564)));
         userService.add(new User("Leonid", "Vostrikov", (byte) 47, "leonid@mail.ru")
                 .setCar(new Car("RAM1500", 43543)));

         List<User> users = userService.listUsers();
         for (User user : users) {
            System.out.println("Id = "+ user.getId());
            System.out.println("First Name = "+ user.getFirstName());
            System.out.println("Last Name = "+ user.getLastName());
            System.out.println("Email = "+ user.getEmail());
            System.out.println();
         }

         User user = userService.getUserByCarSerial("Carra GS7", 4564);
         System.out.println(user);

         context.close();
      }
}
