package contacts;

import contacts.contacts.Contact;
import contacts.contacts.Person;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    final private List<Contact> contacts = new ArrayList<>();

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(int id) {
        contacts.remove(id - 1);
    }

    public void editContact(int id, Person editedPerson) {
        contacts.set(id - 1, editedPerson);
    }

    public Contact getContact(int id) {
        return contacts.get(id - 1);
    }

    public int getPhoneBookSize() {
        return contacts.size();
    }

    public void printAllContacts() {
        int i = 1;
        for (Contact c : contacts) {
            System.out.println(i + ". " + c);
            i++;
        }
    }
}
