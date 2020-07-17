package contacts;

import contacts.contacts.Contact;
import contacts.contacts.Organization;
import contacts.contacts.Person;
import contacts.exceptions.BadBirthDateException;
import contacts.exceptions.BadGenderException;
import contacts.exceptions.WrongNumberException;
import contacts.phonebook.PhoneBook;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final PhoneBook contacts = new PhoneBook();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        while (true) {
            System.out.println("[menu] Enter action (add, list, search, count, exit): > ");
            input = scanner.nextLine();
            switch (input) {
                case "add":
                    printAdd();
                    break;
                case "list":
                    printList();
                    break;
                case "search":
                    printSearch();
                    break;
                case "remove":
                    printRemove();
                    break;
                case "edit":
                    printEdit();
                    break;
                case "count":
                    System.out.println("The Phone Book has " + contacts.getPhoneBookSize() + " records.");
                    break;
                case "exit":
                    scanner.close();
                    return;
            }
            System.out.println();
        }
    }

    private static void printAdd() {
        System.out.println("Enter the type (person, organization): > ");
        String enteredType = scanner.nextLine();

        if (enteredType.equals("person")) {
            printAddPerson();
        } else if (enteredType.equals("organization")) {
            printAddOrganization();
        }
    }

    private static void printAddPerson() {
        Person person = new Person();

        System.out.println("Enter the name: > ");
        person.setName(scanner.nextLine());

        System.out.println("Enter the surname: > ");
        person.setSurname(scanner.nextLine());

        try {
            System.out.println("Enter the birth date: > ");
            person.setBirthDate(scanner.nextLine());
        } catch (BadBirthDateException exc) {
            System.out.println("Bad birth date!");
        }

        try {
            System.out.println("Enter the gender (M, F): > ");
            person.setGender(scanner.nextLine());
        } catch (BadGenderException exc) {
            System.out.println("Bad gender!");
        }

        try {
            System.out.println("Enter the number: > ");
            person.setPhoneNumber(scanner.nextLine());
        } catch (WrongNumberException exc) {
            System.out.println("Wrong number format!");
        }

        contacts.addContact(person);
        System.out.println("The record added.");
    }

    private static void printAddOrganization() {
        Organization organization = new Organization();

        System.out.println("Enter the organization name: > ");
        organization.setName(scanner.nextLine());

        System.out.println("Enter the address: > ");
        organization.setAddress(scanner.nextLine());

        try {
            System.out.println("Enter the number: > ");
            organization.setPhoneNumber(scanner.nextLine());
        } catch (WrongNumberException exc) {
            System.out.println("Wrong number format!");
        }

        contacts.addContact(organization);
        System.out.println("The record added.");

        scanner.close();
    }

    private static void printList() {
        System.out.println(contacts);

        System.out.println("Enter index to show info: > ");
        System.out.println(
                contacts.getContact(Integer.parseInt(scanner.nextLine())).toString()
        );
    }

    private static void printSearch() {
        System.out.println("Enter search query: > ");
        List<String> foundStrings = contacts.find(scanner.nextLine());

        System.out.printf("Found %d results:\n", foundStrings.size());
        int i = 0;
        for (String s : foundStrings) {
            ++i;
            System.out.printf("%d. %s\n", i, s);
        }
    }

    private static void printRemove() {
        if (contacts.getPhoneBookSize() != 0) {
            System.out.println(contacts);
            System.out.println("Select a record: > ");
            contacts.removeContact(Integer.parseInt(scanner.nextLine()));
            System.out.println("The record removed!");
        } else {
            System.out.println("No records to remove!");
        }
    }

    private static void printEdit() {
        if (contacts.getPhoneBookSize() > 0) {
            System.out.println(contacts);

            System.out.println("Select a record: > ");
            int id = Integer.parseInt(scanner.nextLine());
            Contact contact = contacts.getContact(id);

            if (contact instanceof Person) {
                contact = printEditPerson(contact);
            } else if (contact instanceof Organization) {
                contact = printEditOrganization(contact);
            }

            contacts.editContact(id, contact);
            System.out.println("The record updated!");
        } else {
            System.out.println("No records to edit!");
        }
    }

    private static Contact printEditPerson(Contact contact) {
        Person person = (Person) contact;

        System.out.println("Select a field (name, surname, birth, gender, number): >");
        switch (scanner.nextLine()) {
            case "name":
                System.out.println("Enter the name: > ");
                person.setName(scanner.nextLine());
                break;
            case "surname":
                System.out.println("Enter the surname: > ");
                person.setSurname(scanner.nextLine());
                break;
            case "birth":
                try {
                    System.out.println("Enter the birth date: > ");
                    person.setBirthDate(scanner.nextLine());
                } catch (BadBirthDateException exc) {
                    System.out.println("Bad birth date!");
                }
                break;
            case "gender":
                try {
                    System.out.println("Enter the gender (M, F): > ");
                    person.setGender(scanner.nextLine());
                } catch (BadGenderException exc) {
                    System.out.println("Bad gender!");
                }
                break;
            case "number":
                try {
                    System.out.println("Enter the number: > ");
                    person.setPhoneNumber(scanner.nextLine());
                } catch (WrongNumberException exc) {
                    System.out.println("Wrong number format!");
                }
                break;
            default:
                System.out.println("Wrong field!");
                break;
        }

        return person;
    }

    private static Contact printEditOrganization(Contact contact) {
        Organization organization = (Organization) contact;

        System.out.println("Select a field (name, address, number): >");
        switch (scanner.nextLine()) {
            case "name":
                System.out.println("Enter the name: > ");
                organization.setName(scanner.nextLine());
                break;
            case "address":
                System.out.println("Enter the surname: > ");
                organization.setAddress(scanner.nextLine());
                break;
            case "number":
                try {
                    System.out.println("Enter the number: > ");
                    organization.setPhoneNumber(scanner.nextLine());
                } catch (WrongNumberException exc) {
                    System.out.println("Wrong number format!");
                }
                break;
            default:
                System.out.println("Wrong field!");
                break;
        }

        return organization;
    }
}
