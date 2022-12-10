package Anwsers;

public class UserReceiverDemo {
    public static void main(String args[])
    {
        for ( int i = 0; i < 10; i++) {
            UserReceiver userReceiver = new UserReceiver();
            System.out.println(userReceiver.getUser());
        }
    }
}
