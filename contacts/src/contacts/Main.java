package contacts;

import java.util.Scanner;

public class Main {

    private static final PhoneBook contacts = new PhoneBook();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("Enter action (add, remove, edit, count, list, exit): > ");
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
                case "list":
                    contacts.printAllContacts();
                    break;
                case "exit":
                    return;
            }
        }
    }

    private static void printAdd() {
        Contact contact = new Contact();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name: > ");
        contact.setName(scanner.nextLine());

        System.out.println("Enter the surname: > ");
        contact.setSurname(scanner.nextLine());

        System.out.println("Enter the number: > ");
        contact.setPhoneNumber(scanner.nextLine());

        contacts.addContact(contact);
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

            System.out.println("Select a field (name, surname, number): > ");
            switch (scanner.nextLine()) {
                case "name":
                    System.out.println("Enter the name: > ");
                    contact.setName(scanner.nextLine());
                    break;
                case "surname":
                    System.out.println("Enter the surname: > ");
                    contact.setSurname(scanner.nextLine());
                    break;
                case "number":
                    System.out.println("Enter the number: > ");
                    contact.setPhoneNumber(scanner.nextLine());
                    break;
                default:
                    System.out.println("Wrong field!");
                    break;
            }

            contacts.editContact(id, contact);
            System.out.println("The record updated!");
        } else {
            System.out.println("No records to edit!");
        }
    }
}
