package contacts.phonebook;

public class FoundResult {
    private final String foundResult;
    private final int contactId;

    public FoundResult(String foundResult, int contactId) {
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
