public class Stack {

         int[] stack;
         int top;

        public Stack(int size) {
            stack = new int[size];
            top = -1;
        }

        public void push(int element) {
            if (top == stack.length - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            stack[++top] = element;
        }

        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return stack[top--];
        }
        public int peek() {         //its returning but not removing top element
            if (top == -1) {
                System.out.println("Stack is empty");
                return -1;
            }
            return stack[top];
        }
        public int search(int element) {        //for searching the element and returning the index
            int index = 1;
            for (int i = top; i >= 0; i--) {
                if (stack[i] == element) {
                    return index;
                }
                index++;
            }
            return -1;
        }
        public String reverseNumber(int number) {      //this method is reversing the entered number
            while (number > 0) {
                push(number % 10);
                number /= 10;
            }
            int reversed = 0, placeValue = 1;
            while (top != -1) {
                reversed += pop() * placeValue;
                placeValue *= 10;
            }
            return String.valueOf(reversed);
        }

        public String reverseString(String str) {    //this method reverses the entire entered string or sentence
            for (char c : str.toCharArray()) {
                push(c);
            }
            StringBuilder reversed = new StringBuilder();
            while (top != -1) {
                reversed.append((char) pop());
            }
            return reversed.toString();
        }

        public static void main(String[] args) {
            Stack stack = new Stack(10);

            stack.push(10);
            stack.push(20);
            stack.push(30);

            System.out.println("Peek: " + stack.peek());
            System.out.println("Search 20: " + stack.search(20));
            System.out.println("Pop: " + stack.pop());
            System.out.println("Reverse Number 12345: " + stack.reverseNumber(12345));
            System.out.println("Reverse String 'Hello': " + stack.reverseString("Prem Kumar"));
    }
}
