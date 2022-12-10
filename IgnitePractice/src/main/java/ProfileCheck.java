import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class ProfileCheck {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String yourString = "ee_transaction_status_no_transactions_or_external_trades";
        byte[] bytes = yourString.getBytes("UTF-8");
        int sizeInBytes = bytes.length;
        System.out.println("get Byte " + sizeInBytes);
        System.out.println("Happy New Year " + UUID.randomUUID().toString() + "_Robot !");
    }
}
