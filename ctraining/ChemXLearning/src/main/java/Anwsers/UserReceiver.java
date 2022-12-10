package Anwsers;

import java.time.LocalDate;

public class UserReceiver {
    private volatile User user;

    public UserReceiver()
    {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                user = User.UserBuilder.newInstance()
                        .withName("user 1")
                        .withBirthDate(LocalDate.now())
                        .withEmail("user1@shareworks.com")
                        .withPhoneNumber("4031234567").build();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                user = User.UserBuilder.newInstance()
                        .withName("user 2")
                        .withBirthDate(LocalDate.now())
                        .withEmail("user2@shareworks.com")
                        .withPhoneNumber("4031234568").build();
            }
        });

        t1.start();
        t2.start();
    }

    public User getUser()
    {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
