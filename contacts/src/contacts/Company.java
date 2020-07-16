package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Company {

    private String name;
    private String address;
    private String phoneNumber = "[no number]";

    public Company() {
    }

    public Company(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "" + name +" " + address + ", " + phoneNumber;
    }
}
