package contacts;

import contacts.contacts.Contact;
import contacts.contacts.Organization;
import contacts.contacts.Person;
import contacts.exceptions.BadBirthDateException;
import contacts.exceptions.BadGenderException;
import contacts.exceptions.WrongNumberException;
import contacts.phonebook.PhoneBook;
import contacts.phonebook.PhoneBookFoundResult;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final PhoneBook contacts = new PhoneBook();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String input;
        while (true) {
            System.out.print("[menu] Enter action (add, list, search, count, exit): > ");
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
        System.out.print("Enter the type (person, organization): > ");
        String enteredType = scanner.nextLine();

        if (enteredType.equals("person")) {
            printAddPerson();
        } else if (enteredType.equals("organization")) {
            printAddOrganization();
        }
    }

    private static void printAddPerson() {
        Person person = new Person();

        System.out.print("Enter the name: > ");
        person.setName(scanner.nextLine());

        System.out.print("Enter the surname: > ");
        person.setSurname(scanner.nextLine());

        try {
            System.out.print("Enter the birth date: > ");
            person.setBirthDate(scanner.nextLine());
        } catch (BadBirthDateException exc) {
            System.out.println("Bad birth date!");
        }

        try {
            System.out.print("Enter the gender (M, F): > ");
            person.setGender(scanner.nextLine());
        } catch (BadGenderException exc) {
            System.out.println("Bad gender!");
        }

        try {
            System.out.print("Enter the number: > ");
            person.setPhoneNumber(scanner.nextLine());
        } catch (WrongNumberException exc) {
            System.out.println("Wrong number format!");
        }

        contacts.addContact(person);
        System.out.println("The record added.");
    }

    private static void printAddOrganization() {
        Organization organization = new Organization();

        System.out.print("Enter the organization name: > ");
        organization.setName(scanner.nextLine());

        System.out.print("Enter the address: > ");
        organization.setAddress(scanner.nextLine());

        try {
            System.out.print("Enter the number: > ");
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

        System.out.println();
        System.out.print("[list] Enter action ([number], back): > ");
        String input = scanner.nextLine();

        if (isNumeric(input)) {
            final int contactId = Integer.parseInt(input);
            Contact contact = contacts.getContact(contactId);
            System.out.println(contact);

            System.out.println();
            printEditContact(contactId, contact);
        }
    }

    public static boolean isNumeric(final String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException exc) {
            return false;
        }
    }

    private static void printSearch() {
        System.out.print("Enter search query: > ");
        List<PhoneBookFoundResult> foundStrings = contacts.find(scanner.nextLine());

        System.out.printf("Found %d results:\n", foundStrings.size());
        int i = 0;
        for (PhoneBookFoundResult r : foundStrings) {
            ++i;
            System.out.printf("%d. %s\n", i, r.getFoundResult());
        }

        System.out.println();
        printSearchAgain(foundStrings);
    }

    private static void printSearchAgain(final List<PhoneBookFoundResult> foundStrings) {
        System.out.print("[search] Enter action ([number], back, again): >");
        String input = scanner.nextLine();

        if (isNumeric(input)) {
            int number = Integer.parseInt(input);
            int contactId = foundStrings.get(number - 1).getContactId();
            Contact contact = contacts.getContact(contactId);
            System.out.println(contact);

            System.out.println();
            printEditContact(contactId, contact);
        } else if (input.equals("again")) {
            printSearch();
        }
    }

    private static void printEditContact(final int contactId, final Contact contact) {
        System.out.print("[record] Enter action (edit, delete, menu): > ");
        String input = scanner.nextLine();

        while (!input.equals("menu")) {
            if (input.equals("edit")) {
                Contact editedContact = null;
                if (contact instanceof Person) {
                    editedContact = printEditPerson(contact);
                } else if (contact instanceof Organization) {
                    editedContact = printEditOrganization(contact);
                }

                contacts.editContact(contactId, editedContact);
                System.out.println("Saved");
                System.out.println(editedContact);
            } else if (input.equals("delete")) {
                printDeleteContact(contactId);
            }

            System.out.println();
            System.out.print("[record] Enter action (edit, delete, menu): > ");
            input = scanner.nextLine();
        }
    }

    private static Contact printEditPerson(Contact contact) {
        Person person = (Person) contact;

        System.out.print("Select a field (name, surname, birth, gender, number): >");
        switch (scanner.nextLine()) {
            case "name":
                System.out.print("Enter the name: > ");
                person.setName(scanner.nextLine());
                break;
            case "surname":
                System.out.print("Enter the surname: > ");
                person.setSurname(scanner.nextLine());
                break;
            case "birth":
                try {
                    System.out.print("Enter the birth date: > ");
                    person.setBirthDate(scanner.nextLine());
                } catch (BadBirthDateException exc) {
                    System.out.println("Bad birth date!");
                }
                break;
            case "gender":
                try {
                    System.out.print("Enter the gender (M, F): > ");
                    person.setGender(scanner.nextLine());
                } catch (BadGenderException exc) {
                    System.out.println("Bad gender!");
                }
                break;
            case "number":
                try {
                    System.out.print("Enter the number: > ");
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

        System.out.print("Select a field (name, address, number): >");
        switch (scanner.nextLine()) {
            case "name":
                System.out.print("Enter the name: > ");
                organization.setName(scanner.nextLine());
                break;
            case "address":
                System.out.print("Enter the surname: > ");
                organization.setAddress(scanner.nextLine());
                break;
            case "number":
                try {
                    System.out.print("Enter the number: > ");
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

    private static void printDeleteContact(final int contactId) {
        contacts.deleteContact(contactId);
        System.out.println("The record removed!");
    }
}
