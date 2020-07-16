package contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    final private List<Person> people = new ArrayList<>();

    public void addContact(Person person) {
        people.add(person);
    }

    public void removeContact(int id) {
        people.remove(id - 1);
    }

    public void editContact(int id, Person editedPerson) {
        people.set(id - 1, editedPerson);
    }

    public Person getContact(int id) {
        return people.get(id - 1);
    }

    public int getPhoneBookSize() {
        return people.size();
    }

    public void printAllContacts() {
        int i = 1;
        for (Person c : people) {
            System.out.println(i + ". " + c);
            i++;
        }
    }
}
