import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    private Scanner scanner = new Scanner(System.in);

    public void printContactList() {
        System.out.println("\nContact list : ");

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println("\t" + (i+1) + ". " + contacts.get(i).getContactName() + " - " + contacts.get(i).getContactNumber());
        }
    }

    public void addContact() {
        Contacts contact = new Contacts();

        System.out.print("Enter contact name : ");
        contact.setContactName(scanner.nextLine());
        System.out.print("Enter contact number : ");
        contact.setContactNumber(scanner.nextLine());

        contacts.add(contact);
    }

    public void removeContact(String contactName) {
        int index = returnContactIndex(contactName);

        if (index >= 0) {
            contacts.remove(index);
            System.out.println("Contact was removed from directory.");
        }
        else {
            System.out.println("Contact with contact name " + contactName + " not found.");
        }
    }

    public void updateContact(String contactName) {
        int index = returnContactIndex(contactName);

        if (index >= 0) {
            System.out.print("Enter new name for contact : ");
            contacts.get(index).setContactName(scanner.nextLine());
            System.out.println("Enter new contact number : ");
            contacts.get(index).setContactNumber(scanner.nextLine());
        }
        else {
            System.out.println("Contact with contact name " + contactName + " not found.");
        }
    }

    private int returnContactIndex(String contactName) {

        int index = -1;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactName().equals(contactName)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    public void searchContact(String contactName) {

        int position = 0;
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getContactName().equals(contactName) || contacts.get(i).getContactName().equals(contactName.toLowerCase())) {
                position = i + 1;
            }
        }

        if (position > 0) {
            System.out.println("Contact with contact name " + contactName + " found at position " + position);
        }
        else {
            System.out.println("Contact with contact name " + contactName + " not found");
        }
    }
}
