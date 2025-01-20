import java.util.Scanner;

class TextEditor {
    Node head;
    Node tail;

     class Node {          //Node class inside for doubly linked list
        char data;
        Node prev;
        Node next;

    Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
    public void add(char c) {       // Adding a character at the end
        Node newNode = new Node(c);
        if (head == null) {
            head = tail = newNode; // First character in the editor
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    // Insert a character at a specific position
    public void insert(int position, char c) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Node newNode = new Node(c);

        if (position == 1) { // Insert at the beginning
            if (head == null) {
                head = tail = newNode;
            }
            else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        }
        else { // Insert at a specific position
            Node temp = head;
            int index = 1;
            while (temp != null && index < position - 1) {
                temp = temp.next;
                index++;
            }
            if (temp == null) {
                System.out.println("Position out of bounds!");
            } else {
                newNode.next = temp.next;
                if (temp.next != null) {
                    temp.next.prev = newNode;
                }
                temp.next = newNode;
                newNode.prev = temp;

                if (newNode.next == null) {
                    tail = newNode;
                }
            }
        }
    }
    // Delete a character at a specific position
    public void delete(int position) {
        if (head == null) {
            System.out.println("The text is empty!");
            return;
        }
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) { // Delete the first character
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // The list is now empty
            }
        } else { // to delete a entered character at specific position
            Node temp = head;
            int index = 1;
            while (temp != null && index < position) {
                temp = temp.next;
                index++;
            }
            if (temp == null) {
                System.out.println("Position out of bounds!");
            } else {
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
            }
        }
    }
    // Modify a character at a specific position
    public void modify(int position, char newChar) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        Node temp = head;
        int index = 1;
        while (temp != null && index < position) {
            temp = temp.next;
            index++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds!");
        } else {
            temp.data = newChar;
        }
    }
    // Display the current text
    public void display() {
        if (head == null) {
            System.out.println("The text is empty!");
            return;
        }
        Node temp = head;
        System.out.print("Current text: ");
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
}
public class DoublyLinkedListTextEditor {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Text Editor!");
        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. Enter text || 2. Insert text || 3. Delete Text");
            System.out.println("|| 4. Modify text || 5. Display text || 6. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                     boolean stop = false;
                    System.out.println("Enter the characters and press S for stop.");
                    while(!stop) {
                        System.out.print("Enter the character: ");
                        char text = scanner.nextLine().charAt(0);
                        if(text == 'S'){
                            stop = true;
                        }
                        if(!stop){
                            editor.add(text);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter the position: ");
                    int insertPosition = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the character to insert: ");
                    char insertChar = scanner.nextLine().charAt(0);
                    editor.insert(insertPosition, insertChar);
                    break;
                case 3:
                    System.out.print("Enter the position to delete: ");
                    int deletePosition = scanner.nextInt();
                    editor.delete(deletePosition);
                    break;
                case 4:
                    System.out.print("Enter the position to modify: ");
                    int modifyPosition = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the new character: ");
                    char newChar = scanner.nextLine().charAt(0);
                    editor.modify(modifyPosition, newChar);
                    break;
                case 5:
                    editor.display();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the text editor.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
