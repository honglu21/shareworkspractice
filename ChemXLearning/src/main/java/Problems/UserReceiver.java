package Problems;

import java.time.LocalDate;

public class UserReceiver {
    private final User user = new User();

    public UserReceiver()
    {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                user.setName("user 1").setBirthDate(LocalDate.now()).setEmail("user1@shareworks.com").setPhoneNumber("4031234567");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                user.setName("user 2").setBirthDate(LocalDate.now()).setEmail("user2@shareworks.com").setPhoneNumber("4031234568");
            }
        });

        t1.start();
        t2.start();
    }

    public User getUser()
    {
        return user;
    }
}
