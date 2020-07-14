package contacts;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Contact contact = new Contact();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the person:\n> ");
        contact.setName(scanner.nextLine());
        System.out.print("Enter the surname of the person:\n> ");
        contact.setSurname(scanner.nextLine());
        System.out.print("Enter the number::\n> ");
        contact.setPhoneNumber(scanner.nextLine());
        System.out.println();

        PhoneBook phoneBook = new PhoneBook(contact);
        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created!");
    }
}
