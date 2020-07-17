package contacts;

import contacts.contacts.Contact;
import contacts.contacts.Organization;
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

    public void editContact(int id, Contact editedContact) {
        contacts.set(id - 1, editedContact);
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

    public List<String> find(String searchQuery) {
        List<String> searchResult = new ArrayList<>();

        Person p;
        Organization o;
        for (Contact c : contacts) {
            if (c.getCreatedAt().toString().toLowerCase().contains(searchQuery.toLowerCase())) {
                searchResult.add(c.getCreatedAt().toString());
            }
            if (c.getName().toLowerCase().contains(searchQuery.toLowerCase())) {
                searchResult.add(c.getName());
            }
            if (c.getPhoneNumber().toLowerCase().contains(searchQuery.toLowerCase())) {
                searchResult.add(c.getPhoneNumber());
            }
            if (c.getLastEditedAt().toString().toLowerCase().contains(searchQuery.toLowerCase())) {
                searchResult.add(c.getLastEditedAt().toString());
            }

            if (c instanceof Person) {
                p = (Person) c;
                if (p.getSurname().toLowerCase().contains(searchQuery.toLowerCase())) {
                    searchResult.add(p.getSurname());
                }
                if (p.getGenderLetter().toLowerCase().contains(searchQuery.toLowerCase())) {
                    searchResult.add(p.getGenderLetter());
                }
                if (p.getBirthDateString().toLowerCase().contains(searchQuery.toLowerCase())) {
                    searchResult.add(p.getBirthDateString());
                }
            } else if (c instanceof Organization) {
                o = (Organization) c;
                if (o.getAddress().toLowerCase().contains(searchQuery.toLowerCase())) {
                    searchResult.add(o.getAddress());
                }
            }
        }

        return searchResult;
    }
}
