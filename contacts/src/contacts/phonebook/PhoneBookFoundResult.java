package contacts.phonebook;

public class PhoneBookFoundResult {
    private final String foundResult;
    private final int contactId;

    public PhoneBookFoundResult(String foundResult, int contactId) {
        this.foundResult = foundResult;
        this.contactId = contactId;
    }

    public String getFoundResult() {
        return foundResult;
    }

    public int getContactId() {
        return contactId;
    }
}
