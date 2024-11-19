class LinkedList{

    private Node top;

    public static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
        }
    }
    public void insertFirst(int data){     //this method inserts the element at first
        Node n = new Node(data);
        n.next = top;
        top = n;
    }
    public Node deleteFirst(){        //this method deletes the first element
        Node temp = top;
        top = top.next;
        return temp;
    }
    public void displayList(){         //this method displays all the items currently present in list
        Node current = top;
        while(current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }
}

public class StackInLinkedList {
   LinkedList list = new LinkedList();

   public void push(int element){           //this method pushes or adds the element at front
       list.insertFirst(element);
   }
   public void pop(){        //this methods deletes the first element (recently added one).
       list.deleteFirst();
   }
   public void displayStack(){

       list.displayList();
   }
}
class LinkedListStackClient{
    public static void main(String[] args) {
        StackInLinkedList stack = new StackInLinkedList();
        stack.push(50);
        stack.push(70);
        stack.push(90);
        System.out.print("1. Stack after push operations: ");
        stack.displayStack();
        System.out.print("\n\n2. Stack after pop operations: ");
        stack.pop();
        stack.displayStack();

    }
}
