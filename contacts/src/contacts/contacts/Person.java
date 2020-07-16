package contacts.contacts;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {

    private String name;
    private String surname;
    private String phoneNumber = "[no number]";
    private boolean gender;
    private LocalDate birthDate;

    public Person() {
    }

    public Person(String name, String surname, String phoneNumber, boolean gender, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }

    private boolean isPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\+?" +
                "((\\([0-9A-Za-z]+\\)|[0-9A-Za-z]+)"
                + "|([0-9A-Za-z]+[ -]\\([0-9A-Za-z]{2,}\\))|[0-9A-Za-z]+[ -][0-9A-Za-z]{2,})"
                + "([ -][0-9A-Za-z]{2,}[ -]?)*");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    public boolean isMale() {
        return gender;
    }

    public boolean isFemale() {
        return !gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "" + name + " " + surname + ", " + phoneNumber;
    }
}
