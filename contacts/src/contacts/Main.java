package contacts;

import contacts.contacts.Contact;
import contacts.contacts.Organization;
import contacts.contacts.Person;
import contacts.exceptions.BadBirthDateException;
import contacts.exceptions.BadGenderException;
import contacts.exceptions.WrongNumberException;

import java.util.Scanner;

public class Main {

    private static final PhoneBook contacts = new PhoneBook();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Enter action (add, remove, edit, count, info, exit): > ");
            input = scanner.nextLine();
            switch (input) {
                case "add":
                    printAdd();
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
                case "info":
                    printInfo();
                    break;
                case "exit":
                    return;
            }
            System.out.println();
        }
    }

    private static void printAdd() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type (person, organization): > ");
        String enteredType = scanner.nextLine();

        if (enteredType.equals("person")) {
            printAddPerson();
        } else if (enteredType.equals("organization")) {
            printAddOrganization();
        }

        scanner.close();
    }

    private static void printAddPerson() {
        Person person = new Person();
        Scanner scanner = new Scanner(System.in);

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

        scanner.close();
    }

    private static void printAddOrganization() {
        Organization organization = new Organization();
        Scanner scanner = new Scanner(System.in);

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

    private static void printRemove() {
        Scanner scanner = new Scanner(System.in);
        if (contacts.getPhoneBookSize() != 0) {
            contacts.printAllContacts();
            System.out.println("Select a record: > ");
            contacts.removeContact(Integer.parseInt(scanner.nextLine()));
            System.out.println("The record removed!");
        } else {
            System.out.println("No records to remove!");
        }
        scanner.close();
    }

    private static void printEdit() {
        Scanner scanner = new Scanner(System.in);

        if (contacts.getPhoneBookSize() > 0) {
            contacts.printAllContacts();

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

        scanner.close();
    }
            switch (scanner.nextLine()) {
                case "name":
                    System.out.println("Enter the name: > ");
                    person.setName(scanner.nextLine());
                    break;
                case "surname":
                    System.out.println("Enter the surname: > ");
                    person.setSurname(scanner.nextLine());
                    break;
                case "number":
                    System.out.println("Enter the number: > ");
                    person.setPhoneNumber(scanner.nextLine());
                    break;
                default:
                    System.out.println("Wrong field!");
                    break;
            }

            contacts.editContact(id, person);
            System.out.println("The record updated!");
        } else {
            System.out.println("No records to edit!");
        }
    }

    private static void printInfo() {
        Scanner scanner = new Scanner(System.in);

        contacts.printAllContacts();

        System.out.println("Enter index to show info: > ");
        System.out.println(
                contacts.getContact(Integer.parseInt(scanner.nextLine())).toString()
        );
    }
}
