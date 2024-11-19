class LinkedLisT{
 private Node front;
 private Node rear;

 static class Node {
     public int data;
     public Node next;

     public Node(int data) {
         this.data = data;
         this.next = null;
     }
 }

 public boolean isEmpty() {
     return (front == null);
 }

 public void insertLast(int new_data) {
     Node new_node = new Node(new_data);
     if (isEmpty()) {
         front = new_node;
     }
     else {
         rear.next = new_node;
     }
     rear = new_node;
 }
 public int deleteFirst() {
     int temp = front.data;
     if (front.next == null) {
         rear = null;
     }
     front = front.next;
     return temp;
 }
 void displayList() {
     System.out.println("===Displaying Elements of DEQ===");
     Node current = front;
     while (current != null) {
         System.out.println(current.data);
         current = current.next;
     }
  }
}
public class LinkedListInQueue {

        LinkedLisT list;

        public LinkedListInQueue() {
            list = new LinkedLisT();
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void enqueue(int new_data) {
            list.insertLast(new_data);
        }

        public int dequeue() {
            return list.deleteFirst();
        }

        void printQueue() {
            list.displayList();
        }
    }

    class QueueClient_2 {
        public static void main(String[] args) {
            LinkedListInQueue list = new LinkedListInQueue();
            list.enqueue(10);
            list.enqueue(20);
            list.enqueue(30);
            list.enqueue(40);
            list.printQueue();
            list.dequeue();
            list.printQueue();
        }
    }

