package Problems;

import java.time.LocalDate;

public class UserDriver {
    public static void main(String args[]) {
        User user1 = new User();
        user1.setName("user 1").setBirthDate(LocalDate.now()).setEmail("user1@shareworks.com").setPhoneNumber("4031234567");
        User user2 = new User();
        user2.setName("user 2").setBirthDate(LocalDate.now()).setEmail("user2@shareworks.com").setPhoneNumber("4031234568");

        System.out.println(user1);
        System.out.println(user2);
    }
}
