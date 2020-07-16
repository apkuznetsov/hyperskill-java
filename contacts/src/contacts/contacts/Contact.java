package contacts.contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contact {

    private String name;
    private String phoneNumber = "[no number]";

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isPhoneNumber(phoneNumber)){
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }

    private boolean isPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\+?" +
                "((\\([0-9A-Za-z]+\\)|[0-9A-Za-z]+)"
                +"|([0-9A-Za-z]+[ -]\\([0-9A-Za-z]{2,}\\))|[0-9A-Za-z]+[ -][0-9A-Za-z]{2,})"
                +"([ -][0-9A-Za-z]{2,}[ -]?)*");
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}
