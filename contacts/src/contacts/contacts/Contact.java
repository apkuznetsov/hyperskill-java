package contacts.contacts;

import contacts.exceptions.WrongNumberException;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private final LocalDate createdAt;
    private String name;
    private String phoneNumber = "[no number]";
    private LocalDate lastEditedAt;

    public Contact() {
        createdAt = LocalDate.now();
        lastEditedAt = createdAt;
    }

    public Contact(String name, String phoneNumber) {
        this();
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        lastEditedAt = createdAt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            lastEditedAt = createdAt;
        } else {
            this.phoneNumber = "[no number]";
            throw new WrongNumberException();
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getLastEditedAt() {
        return lastEditedAt;
    }
}
