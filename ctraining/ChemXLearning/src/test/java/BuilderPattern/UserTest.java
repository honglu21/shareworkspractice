package BuilderPattern;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDate;

@Ignore
public class UserTest {

    public static final String NAME = "Bond";
    public static final String EMAIL = "james@bond.co.uk";
    public static final String PHONE_NUMBER = "007007007";

    @Test
    public void shouldCreateACompleteUser() {

        LocalDate now = LocalDate.now();

        User user = User.builder()
                .withName(NAME)
                .withEmail(EMAIL)
                .withBirthDate(now)
                .withPhoneNumber(PHONE_NUMBER)
                .build();

        Assert.assertEquals(NAME, user.getName());
        Assert.assertEquals(EMAIL, user.getEmail());
        Assert.assertEquals(now, user.getBirthDate());
        Assert.assertEquals(PHONE_NUMBER, user.getPhoneNumber());
    }
}

