import java.util.Scanner;

public class LinkedList {

    private final String listName;
    private Node root, currentNode;
    private final Scanner scanner = new Scanner(System.in);

    public LinkedList(String listName) {
        this.listName = listName;
        root = new Node();
        root.setValue(null);
        root.setNext(null);
        root.setPrevious(null);

        currentNode = new Node();
        currentNode.setValue(null);
        currentNode.setNext(null);
        currentNode.setPrevious(null);
    }

    public void add() {
        System.out.print("Enter a string : ");
        String value = scanner.nextLine();
        Node newNode = new Node();
        newNode.setValue(value);
        currentNode = root;

        while (currentNode.getNext() != null) {
            currentNode = (Node) currentNode.getNext();
        }
        insertAfter(currentNode, newNode);
        System.out.println("New node with value " + value + " has been inserted at the end of the linked list");
    }

    public void addInOrder() {

        if (root.getNext() == null) {
            add();
        }
        else {
            System.out.print("Enter a string : ");
            String value = scanner.nextLine();
            Node newNode = new Node();
            newNode.setValue(value);
            currentNode = (Node) root.getNext();

            while (ListItem.compareTo(currentNode, newNode) > 0) {
                currentNode.setNext((Node) currentNode.getNext());

                if (currentNode.getNext() == null) {
                    break;
                }
            }
            insertAfter(currentNode, newNode);

            System.out.println("New node with value " + value + " has been inserted lexicographically in the list");
        }
    }

    private void insertBefore(Node currentNode, Node newNode) {

        if (currentNode.previous != null) {
            insertAfter((Node) currentNode.previous, newNode);
        }
    }

    private void insertAfter(Node currentNode, Node newNode) {
        newNode.setNext((Node) currentNode.getNext());
        newNode.setPrevious(currentNode);
        currentNode.setNext(newNode);
    }

    public void printList() {

        System.out.println("Root Node = " + root + "  Root Node Value = " + root.getValue() + "  Root Node Next = " + root.getNext() + "  Root Node Previous = " + root.getPrevious());
        System.out.println("List " + listName + " : ");
        currentNode = (Node) root.getNext();

        while (currentNode.getNext() != null) {
            System.out.println("    - " + currentNode.getValue());
            currentNode = (Node) currentNode.getNext();
        }
        System.out.println("    - " + currentNode.getValue());
    }
}
