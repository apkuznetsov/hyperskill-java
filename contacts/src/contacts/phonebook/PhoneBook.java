package contacts.phonebook;

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

    public Contact getContact(final int id) {
        return contacts.get(id - 1);
    }

    public void editContact(final int id, Contact editedContact) {
        contacts.set(id - 1, editedContact);
    }

    public void deleteContact(final int id) {
        contacts.remove(id - 1);
    }

    public int getPhoneBookSize() {
        return contacts.size();
    }

    public List<PhoneBookFoundResult> find(String searchQuery) {
        List<PhoneBookFoundResult> searchResult = new ArrayList<>();

        Contact c;
        int id;
        String createdAt;
        String name;
        String phoneNumber;
        String lastEditedAt;
        String gender;

        Person p;
        String surname;
        String birthDate;

        Organization o;
        String address;

        final String query = searchQuery.toLowerCase();
        for (int i = 0; i < contacts.size(); i++) {
            c = contacts.get(i);
            id = i + 1;

            createdAt = c.getCreatedAt().toString();
            if (createdAt.toLowerCase().contains(query)) {
                searchResult.add(new PhoneBookFoundResult(createdAt, id));
            }

            name = c.getName();
            if (name.toLowerCase().contains(query)) {
                searchResult.add(new PhoneBookFoundResult(name, id));
            }

            phoneNumber = c.getPhoneNumber();
            if (phoneNumber.toLowerCase().contains(query)) {
                searchResult.add(new PhoneBookFoundResult(phoneNumber, id));
            }

            lastEditedAt = c.getLastEditedAt().toString();
            if (lastEditedAt.toLowerCase().contains(query)) {
                searchResult.add(new PhoneBookFoundResult(lastEditedAt, id));
            }

            if (c instanceof Person) {
                p = (Person) c;

                surname = p.getSurname();
                if (surname.toLowerCase().contains(query)) {
                    searchResult.add(new PhoneBookFoundResult(surname, id));
                }

                gender = p.getGenderString();
                if (gender.toLowerCase().contains(query)) {
                    searchResult.add(new PhoneBookFoundResult(gender, id));
                }

                birthDate = p.getBirthDateString();
                if (birthDate.toLowerCase().contains(query)) {
                    searchResult.add(new PhoneBookFoundResult(birthDate, id));
                }
            } else if (c instanceof Organization) {
                o = (Organization) c;

                address = o.getAddress();
                if (address.toLowerCase().contains(query)) {
                    searchResult.add(new PhoneBookFoundResult(address, id));
                }
            }
        }

        return searchResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int i = 1;
        for (Contact c : contacts) {
            sb.append(i).append(". ").append(c);
            i++;
        }

        return sb.toString();
    }
}
