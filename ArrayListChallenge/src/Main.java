/* 	    // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed above.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the ArrayList to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.
*/

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        MobilePhone Nokia3310 = new MobilePhone();
        boolean loop = true;
        int choice;

        while(loop) {

            printChoices();

            System.out.print("\nEnter your choice : ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Nokia3310.printContactList();
                    break;
                case 2:
                    System.out.print("\nEnter name of contact to be searched for : ");
                    String contactName = scanner.nextLine();
                    Nokia3310.searchContact(contactName);
                case 3:
                    Nokia3310.addContact();
                    break;
                case 4:
                    System.out.print("\nEnter name of contact to be updated : ");
                    contactName = scanner.nextLine();
                    Nokia3310.updateContact(contactName);
                    break;
                case 5:
                    System.out.print("\nEnter name of contact to be removed : ");
                    contactName = scanner.nextLine();
                    Nokia3310.removeContact(contactName);
                    break;
                case 6:
                    loop = false;
                    System.out.println("Quitting..");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void printChoices() {

        System.out.println("\n1. Print contact list");
        System.out.println("2. Search for a contact");
        System.out.println("3. Add contact");
        System.out.println("4. Update contact");
        System.out.println("5. Remove contact");
        System.out.println("6. Quit application");
    }
}
