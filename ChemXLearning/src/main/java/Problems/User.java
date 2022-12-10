package Problems;

import java.time.LocalDate;

public class User {
    private String name;
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;

//    public User(String name, LocalDate birthDate, String email, String phoneNumber) {
//        this.name = name;
//        this.birthDate = birthDate;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public User setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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

    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

}
