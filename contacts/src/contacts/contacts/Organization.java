package contacts.contacts;

public class Organization extends Contact {

    private String address;

    public Organization(String name, String address, String phoneNumber) {
        super(name, phoneNumber);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "" + super.getName() + " " + address + ", " + super.getPhoneNumber();
    }
}
