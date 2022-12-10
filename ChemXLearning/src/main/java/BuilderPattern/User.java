package BuilderPattern;

import java.time.LocalDate;

public class User {

    private final String name;
    private final LocalDate birthDate;
    private final String email;
    private final String phoneNumber;

    public User(String name, LocalDate birthDate, String email, String phoneNumber) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static UserBuilder builder(){
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String name;
        private LocalDate birthDate;
        private String email;
        private String phoneNumber;

        public UserBuilder withName(String name) {
            //TODO
            return null;
        }

        public UserBuilder withBirthDate(LocalDate birthDate) {
            //TODO
            return null;
        }

        public UserBuilder withEmail(String email) {
            //TODO
            return null;
        }

        public UserBuilder withPhoneNumber(String phoneNumber) {
            //TODO
            return null;
        }

        public User build() {
            //TODO
            return null;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

